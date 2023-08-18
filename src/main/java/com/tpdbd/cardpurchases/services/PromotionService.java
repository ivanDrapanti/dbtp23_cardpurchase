package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Bank;
import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.model.Promotion;
import com.tpdbd.cardpurchases.model.Purchase;
import com.tpdbd.cardpurchases.repository.BankRepository;
import com.tpdbd.cardpurchases.repository.PromotionRepository;
import com.tpdbd.cardpurchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;

import static java.util.Objects.isNull;

@Service
public class PromotionService {
  private final PromotionRepository promotionRepository;
  private final BankRepository bancoRepository;
  private final PurchaseRepository purchaseRepository;
  public PromotionService(BankRepository bancoRepository, PromotionRepository promotionRepository, PurchaseRepository purchaseRepository) {
    this.bancoRepository = bancoRepository;
    this.promotionRepository = promotionRepository;
    this.purchaseRepository = purchaseRepository;
  }
  public void createDiscount(String bankCuit, Discount discount){
    Bank bank = bancoRepository.findByCuit(bankCuit);
    if(isNull(bank))
      throw new NoSuchElementException("Banco no encontrado con el CUIT: " + bankCuit);

    discount.setBank(bank);
    promotionRepository.save(discount);
  }

  public void deleteDiscount(String code) {
    checkIfIsUsedByPurchase(code);
    promotionRepository.deleteByCode(code);
  }

  private void checkIfIsUsedByPurchase(String code) {
    Set<Purchase> purchases = purchaseRepository.findByValidPromotionCode(code);
    purchases.forEach(v -> v.setValidPromotion(null));
  }

  public Set<Promotion> getPromotion(String bank, Date startDate, Date endDate) {
    return this.promotionRepository.findByValidityStartDateLessThanAndValidityEndDateGreaterThanAndBank(startDate, endDate, bank);
  }

  public Promotion getBestPromotion() {
    Promotion promotion = this.promotionRepository.findPromotionWithMaxPurchaseCount();
    return this.promotionRepository.findById(promotion.getId()).get();
  }
}
