package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Bank;
import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.repository.BankRepository;
import com.tpdbd.cardpurchases.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PromotionService {
  private final PromotionRepository promotionRepository;
  private final BankRepository bancoRepository;
  public PromotionService(BankRepository bancoRepository, PromotionRepository promotionRepository) {
    this.bancoRepository = bancoRepository;
    this.promotionRepository = promotionRepository;
  }
  public void createDiscount(String bankCuit, Discount discount){
    Bank bank = bancoRepository.findById(bankCuit)
            .orElseThrow(() -> new NoSuchElementException("Banco no encontrado con el CUIT: " + bankCuit));

    discount.setBank(bank);
    promotionRepository.save(discount);
  }
}
