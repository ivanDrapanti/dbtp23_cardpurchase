package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Purchase;
import com.tpdbd.cardpurchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
  private final PurchaseRepository purchaseRepository;
  public PurchaseService(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  public Purchase getPurchase(String type, String id){
    return this.purchaseRepository.findByTypeAndId(type, id);
  }
}
