package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

  @Id
  @Column
  private String number;
  @Column
  private String ccv;
  @Column(name = "card_holder_name_in_card")
  private String cardHolderNameInCard;
  @Column
  private Date since;
  @Column
  private Date expirationDate;
  @ManyToOne
  @JoinColumn(name = "bank_cuit")
  private Bank bank;

  @ManyToOne
  @JoinColumn(name = "card_holder_dni")
  private CardHolder cardHolder;

  @OneToMany(
          mappedBy = "card",
          fetch = FetchType.LAZY,
          targetEntity = Purchase.class
  )
  private Set<Purchase> purchases;
}
