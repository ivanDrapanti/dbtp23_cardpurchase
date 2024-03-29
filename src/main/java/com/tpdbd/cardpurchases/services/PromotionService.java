package com.tpdbd.cardpurchases.services;

import com.tpdbd.cardpurchases.model.Bank;
import com.tpdbd.cardpurchases.model.Discount;
import com.tpdbd.cardpurchases.model.Promotion;
import com.tpdbd.cardpurchases.model.Purchase;
import com.tpdbd.cardpurchases.repository.BankRepository;
import com.tpdbd.cardpurchases.repository.PromotionRepository;
import com.tpdbd.cardpurchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public class PromotionService {
  private final PromotionRepository promotionRepository;
  private final BankRepository bancoRepository;
  private final PurchaseRepository purchaseRepository;
  public PromotionService(BankRepository bancoRepository, PromotionRepository promotionRepository, PurchaseRepository purchaseRepository) {
    this.bancoRepository = bancoRepository;
    this.promotionRepository = promotionRepository;
    this.purchaseRepository = purchaseRepository;
  }
  public void createDiscount(String bankCuit, Discount discount){
    Bank bank = bancoRepository.findById(bankCuit)
            .orElseThrow(() -> new NoSuchElementException("Banco no encontrado con el CUIT: " + bankCuit));

    discount.setBank(bank);
    promotionRepository.save(discount);
  }

  public void deleteDiscount(String code) {
    Promotion promotion = promotionRepository.findById(code).get();
    promotion.setActive(false);
    promotionRepository.save(promotion);
  }

  public Set<Promotion> getPromotion(String bank, Date startDate, Date endDate) {
    return this.promotionRepository.findByValidityStartDateLessThanAndValidityEndDateGreaterThanAndBankCuit(startDate, endDate, bank);
  }

  public Promotion getBestPromotion() {
    return this.promotionRepository.findPromotionWithMaxPurchaseCount();
  }
}
