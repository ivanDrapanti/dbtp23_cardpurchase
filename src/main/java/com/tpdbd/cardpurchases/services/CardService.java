package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.*;
import com.tpdbd.cardpurchases.repository.CardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardService {
  private final CardRepository cardRepository;

  public CardService(CardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

  public List<Card> getCardsToExpirate(String days) {
    Date startDate = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(days));
    Date endDate = calendar.getTime();
    return cardRepository.findByExpirationDateBetween(startDate, endDate);
  }

  public List<String> getTop10BestBuyers() {

    AggregationResults<Card> cards = cardRepository.findTop10CardsByPurchaseCount();
    List<String> owners = new ArrayList<>();
    for (Card card : cards.getMappedResults()){
      Card card1 = cardRepository.findById(card.getId()).get();
      owners.add("DNI: " + card1.getCardHolder().getDni());
    }
    return owners;
  }

  public Payment getPaymentFromCard(String number, Date date) {
    Card card = cardRepository.findByNumber(number);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = calendar.get(Calendar.MONTH);
    int year = calendar.get(Calendar.YEAR);
    List<Purchase> purchases = getPurchasesByMonthAndYear(card.getPurchases(), month, year);

    Payment payment = new Payment();

    float totalPrice = 0F;
    for (Purchase purchase : purchases) {
      if (purchase instanceof MonthlyPayments monthlyPayments) {
        Set<Quota> quotas = monthlyPayments.getQuotas();
        Quota quota = quotas.stream()
                .filter(v -> (String.valueOf(month).equals(v.getMonth()) && String.valueOf(year).equals(v.getYear())))
                .findFirst()
                .orElse(null);
        if (quota != null && quota.getPayment() == null) {
          totalPrice += quota.getPrice();
          payment.addQuota(quota);
        }
      } else if (purchase instanceof CashPayment cashPayment) {
        payment.addCashPayment(cashPayment);
        totalPrice += cashPayment.getFinalAmount();
      }
    }

    payment.setMonth(String.valueOf(month));
    payment.setYear(String.valueOf(year));
    payment.setTotalPrice(totalPrice);

    return payment;
  }

  /**
   * Obtengo todos los Purchases filtrando por mes y año
   */
  private List<Purchase> getPurchasesByMonthAndYear(List<Purchase> purchases, int month, int year) {
    List<Purchase> result = new ArrayList<>();

    Calendar calendar = Calendar.getInstance();

    for (Purchase purchase : purchases) {
      if (purchase instanceof CashPayment cashPayment) {
        calendar.setTime(cashPayment.getDate());
        if (calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.YEAR) == year) {
          result.add(cashPayment);
        }
      } else if (purchase instanceof MonthlyPayments monthlyPayments) {
        result.add(monthlyPayments);
      }
    }

    return result;
  }
}
