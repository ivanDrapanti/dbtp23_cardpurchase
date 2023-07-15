package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card_holder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardHolder {

  @Id
  @Column
  private String dni;
  @Column
  private String completeName;
  @Column
  private String cuil;
  @Column
  private String address;
  @Column
  private String telephone;
  @Column
  private Date entry;

  @ManyToMany(fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinTable(
          name = "bank_cardholder",
          joinColumns = @JoinColumn(name = "cardholder_id"),
          inverseJoinColumns = @JoinColumn(name = "bank_id")
  )
  private Set<Bank> banks = new HashSet<>(0);
  @OneToMany(mappedBy = "cardHolder",
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          targetEntity = Card.class)
  @JsonIgnore
  private Set<Card> cards = new HashSet<>(0);
}
