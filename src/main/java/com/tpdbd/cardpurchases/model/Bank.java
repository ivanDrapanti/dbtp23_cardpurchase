package com.tpdbd.cardpurchases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

  @Id
  private String id;
  private String cuit;
  private String name;
  private String address;
  private String telephone;
  private String direction;
  @DBRef(lazy = true)
  private Set<Card> cards = new HashSet<>(0);
  @DBRef(lazy = true)
  private Set<CardHolder> members = new HashSet<>(0);
  @DBRef(lazy = true)
  private Set<Promotion> promotions = new HashSet<>(0);
}
