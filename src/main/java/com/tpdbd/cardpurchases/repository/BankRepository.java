package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<Bank, String> {
  Bank findByCuit(String cuit);
}
