package com.tpdbd.cardpurchases.controller;

import com.tpdbd.cardpurchases.services.PaymentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PutMapping("/payments/{code}")
  public ResponseEntity<String> updatePayment(
          @PathVariable String code,
          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date firstExpiration,
          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date secondExpiration) {
    try {
      paymentService.updatePayment(code, firstExpiration, secondExpiration);
      return ResponseEntity.ok("Pago editado exitosamente.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al editar el pago.");
    }
  }
}
