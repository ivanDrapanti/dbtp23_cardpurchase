package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
}
