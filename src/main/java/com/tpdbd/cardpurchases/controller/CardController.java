package com.tpdbd.cardpurchases.controller;

import com.tpdbd.cardpurchases.services.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
  private final CardService cardService;
  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping("/card/{days}")
  public ResponseEntity<? extends Object> getCards(
          @PathVariable String days){
    try {
      return ResponseEntity.ok(cardService.getCardsToExpirate(days));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener tarjetas.");
    }
  }
}
