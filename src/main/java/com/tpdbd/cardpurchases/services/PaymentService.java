package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Payment;
import com.tpdbd.cardpurchases.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

@Service
public class PaymentService {
  private final PaymentRepository paymentRepository;
  public PaymentService(PaymentRepository paymentRepository){
    this.paymentRepository = paymentRepository;
  }

  public Payment updatePayment(String code, Date firstExpiration, Date secondExpiration){
    Payment payment = paymentRepository.findByCode(code);
    if(isNull(payment)) throw new NoSuchElementException("Pago no encontrado con el Codigo: " + code);

    payment.setFirstExpiration(firstExpiration);
    payment.setSecondExpiration(secondExpiration);
    paymentRepository.save(payment);

    return payment;
  }
}
