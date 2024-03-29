package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, String> {
  Purchase findByTypeAndId(String type, String id);
  Set<Purchase> findByValidPromotionCode(String code);
}
