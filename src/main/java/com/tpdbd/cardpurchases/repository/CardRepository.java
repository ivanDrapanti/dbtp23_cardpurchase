package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
  List<Card> findByExpirationDateBetween(Date startDate, Date endDate);
}
