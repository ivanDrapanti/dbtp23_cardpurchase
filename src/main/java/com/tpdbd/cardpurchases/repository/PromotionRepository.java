package com.tpdbd.cardpurchases.repository;

import com.tpdbd.cardpurchases.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Discount, String> {

}
