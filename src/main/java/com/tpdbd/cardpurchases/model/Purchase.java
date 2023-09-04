package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true)
  private long id;

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

  @Column
  private Date date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "card")
  @JsonIgnore
  private Card card;

  @Column(name = "type", insertable = false, updatable = false)
  private String type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "promotion")
  private Promotion validPromotion;

  @JsonProperty("card")
  public String getCardNumber() {
    return this.card != null ? this.card.getNumber() : null;
  }
}
