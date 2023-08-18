package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.MonthlyPayments;
import com.tpdbd.cardpurchases.model.Purchase;
import com.tpdbd.cardpurchases.model.Quota;
import com.tpdbd.cardpurchases.repository.PromotionRepository;
import com.tpdbd.cardpurchases.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
  private final PurchaseRepository purchaseRepository;
  private final PromotionRepository promotionRepository;
  public PurchaseService(PurchaseRepository purchaseRepository, PromotionRepository promotionRepository) {
    this.purchaseRepository = purchaseRepository;
    this.promotionRepository = promotionRepository;
  }

  public Purchase getPurchase(String type, String id){
    return this.purchaseRepository.findByTypeAndId(type, id);
  }

  public String getTotalPricePurchase(String type, String id) {
    //Only support MonthlyPayments.
    MonthlyPayments purchase = (MonthlyPayments) this.purchaseRepository.findByTypeAndId(type, id);
    float totalPrice = 0F;
    for (Quota quota : purchase.getQuotas())
      totalPrice += quota.getPrice();

    return String.format("Total Price is: %f", totalPrice);
  }
}
