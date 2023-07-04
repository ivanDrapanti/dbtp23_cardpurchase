package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
