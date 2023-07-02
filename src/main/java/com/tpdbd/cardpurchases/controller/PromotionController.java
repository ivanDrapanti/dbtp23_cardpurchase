package com.tpdbd.cardpurchases.controller;

import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.services.PromotionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {

  private final PromotionService promotionService;

  public PromotionController(PromotionService promotionService) {
    this.promotionService = promotionService;
  }
  @PostMapping("/discounts/{bankCuit}")
  public ResponseEntity<String> addDiscount(
          @PathVariable String bankCuit,
          Discount discount) {
    try {
      promotionService.createDiscount(bankCuit, discount);
      return ResponseEntity.ok("Descuento creado exitosamente.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el descuento.");
    }
  }
}
