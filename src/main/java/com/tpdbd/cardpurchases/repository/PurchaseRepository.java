package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.CashPayment;
import com.tpdbd.cardpurchases.model.MonthlyPayments;
import com.tpdbd.cardpurchases.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {
  Purchase findByTypeAndId(String type, String id);
  Set<Purchase> findByValidPromotionCode(String code);
}
