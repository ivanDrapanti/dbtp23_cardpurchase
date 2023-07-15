package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

  @Id
  @Column
  private String cuit;
  @Column(name = "bank_name") //name is reserved by MySQL
  private String name;
  @Column
  private String address;
  @Column
  private String telephone;
  @Column
  private String direction;
  @OneToMany(mappedBy = "bank",
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          orphanRemoval = true,
          targetEntity = Card.class)
  private Set<Card> cards = new HashSet<>(0);
  @ManyToMany(fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
  @JoinTable(
          name = "bank_cardholder",
          joinColumns = @JoinColumn(name = "bank_id"),
          inverseJoinColumns = @JoinColumn(name = "cardholder_id")
  )
  private Set<CardHolder> members = new HashSet<>(0);
  @OneToMany(mappedBy = "bank",
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          orphanRemoval = true,
          targetEntity = Promotion.class)
  private Set<Promotion> promotions = new HashSet<>(0);
}
