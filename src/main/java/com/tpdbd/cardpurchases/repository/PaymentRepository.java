package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
  Payment findByCode(String code);
}
