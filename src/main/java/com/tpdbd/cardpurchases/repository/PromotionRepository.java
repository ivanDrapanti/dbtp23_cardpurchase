package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String> {
  Set<Promotion> findByValidityStartDateLessThanAndValidityEndDateGreaterThanAndBankCuit(Date startDate, Date endDate, String bankCuit);

  @Query("SELECT c FROM Promotion c JOIN c.purchases p GROUP BY c.id ORDER BY COUNT(p) DESC")
  Promotion findPromotionWithMaxPurchaseCount();
}
