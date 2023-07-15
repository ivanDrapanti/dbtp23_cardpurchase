package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

  Card findByNumber(String number);
  List<Card> findByExpirationDateBetween(Date startDate, Date endDate);
  @Query("SELECT c FROM Card c JOIN c.purchases p GROUP BY c.id ORDER BY COUNT(p) DESC")
  List<Card> findTop10CardsByPurchaseCount();
}
