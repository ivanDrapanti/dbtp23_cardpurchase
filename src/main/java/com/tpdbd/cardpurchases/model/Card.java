package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
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
  @ManyToOne(fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
  @JoinColumn(name = "bank_cuit")
  @JsonIgnore
  private Bank bank;

  @ManyToOne(fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          targetEntity = CardHolder.class)
  @JoinColumn(name = "card_holder_dni")
  @JsonIgnore
  private CardHolder cardHolder;

  @OneToMany(
          mappedBy = "card",
          fetch = FetchType.LAZY,
          targetEntity = Purchase.class
  )
  @JsonIgnore
  private Set<Purchase> purchases = new HashSet<>(0);

  @JsonProperty("purchases")
  public Set<String> getPurchasesByIds() {
    Set<String> ids = new HashSet<>();
    for (Purchase purchase : purchases) {
      ids.add(purchase.getId());
    }
    return ids;
  }
}
