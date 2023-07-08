package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Card;
import com.tpdbd.cardpurchases.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CardService {
  private final CardRepository cardRepository;
  public CardService(CardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

  public List<Card> getCardsToExpirate(String days){
    Date startDate = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(days));
    Date endDate = calendar.getTime();
    return cardRepository.findByExpirationDateBetween(startDate, endDate);
  }
}
