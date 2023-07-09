package com.tpdbd.cardpurchases.controller;

import com.tpdbd.cardpurchases.services.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {
  private final PurchaseService service;
  public PurchaseController(PurchaseService purchaseService) {
    this.service = purchaseService;
  }

  @GetMapping("purchases/{type}")
  public ResponseEntity<? extends Object> getPurchaseById(
          @PathVariable String type,
          @RequestParam(name = "id") String id
  ) {
    try {
      return ResponseEntity.ok(this.service.getPurchase(type, id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
