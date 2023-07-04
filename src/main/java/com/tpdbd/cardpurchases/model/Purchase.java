package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.STRING,
        length = 1)
public abstract class Purchase {

  @Id
  @Column
  private String id;

  @Column
  private String paymentVoucher;

  @Column
  private String store;

  @Column
  private String cuitStore;

  @Column
  private float amount;

  @Column
  private float finalAmount;

  @ManyToOne
  @JoinColumn(name = "card")
  private Card card;

  @Column(name = "type", insertable = false, updatable = false)
  private String type;

  @ManyToOne
  @JoinColumn(name = "promotion")
  private Promotion validPromotion;
}
