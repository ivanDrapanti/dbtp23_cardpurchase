package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface PromotionRepository extends JpaRepository<Discount, String> {
  Set<Promotion> findByValidityStartDateLessThanAndValidityEndDateGreaterThanAndBankCuit(Date startDate, Date endDate, String bankCuit);
}
