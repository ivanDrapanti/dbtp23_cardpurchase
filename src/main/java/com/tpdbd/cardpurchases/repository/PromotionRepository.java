package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Promotion;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface PromotionRepository extends MongoRepository<Promotion, String> {
  Set<Promotion> findByValidityStartDateLessThanAndValidityEndDateGreaterThanAndBank(Date startDate, Date endDate, String bank);

  Promotion deleteByCode(String code);
  @Aggregation(pipeline = {
          "{ $project: { totalPurchases: { $size: '$purchases' } } }",
          "{ $sort: { totalPurchases: -1 } }",
          "{ $limit: 1 }"
  })
  Promotion findPromotionWithMaxPurchaseCount();
}
