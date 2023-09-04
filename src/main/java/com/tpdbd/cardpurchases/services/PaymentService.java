package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Payment;
import com.tpdbd.cardpurchases.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PaymentService {
  private final PaymentRepository paymentRepository;
  public PaymentService(PaymentRepository paymentRepository){
    this.paymentRepository = paymentRepository;
  }

  public Payment updatePayment(String code, Date firstExpiration, Date secondExpiration){
    Payment payment = paymentRepository.findById(code)
            .orElseThrow(() -> new NoSuchElementException("Pago no encontrado con el Codigo: " + code));

    payment.setFirstExpiration(firstExpiration);
    payment.setSecondExpiration(secondExpiration);
    paymentRepository.save(payment);

    return payment;
  }
}
