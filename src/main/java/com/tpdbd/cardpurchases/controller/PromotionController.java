package com.tpdbd.cardpurchases.controller;

import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.services.PromotionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

  @DeleteMapping("/promotions/{code}")
  public ResponseEntity<String> deletePromotion(
          @PathVariable String code
  ) {
    try {
      promotionService.deleteDiscount(code);
      return ResponseEntity.ok("Promoción eliminado exitosamente.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el descuento.");
    }
  }

  @GetMapping("/promotions/{bank}")
  public ResponseEntity getPromotion(
          @PathVariable String bank,
          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate
  ) {
    try {
      return ResponseEntity.ok(promotionService.getPromotion(bank, startDate, endDate));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error trayendo las promociones");
    }
  }
}
