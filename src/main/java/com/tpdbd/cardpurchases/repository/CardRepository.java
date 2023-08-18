package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Card;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

  Card findByNumber(String number);
  List<Card> findByExpirationDateBetween(Date startDate, Date endDate);
  @Aggregation(pipeline = {
          "{ $unwind: '$purchases' }",
          "{ $group: { _id: '$_id', totalPurchases: { $sum: 1 } } }",
          "{ $sort: { totalPurchases: -1 } }",
          "{ $limit: 10 }"
  })
  AggregationResults<Card> findTop10CardsByPurchaseCount();
}
