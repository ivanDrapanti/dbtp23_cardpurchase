package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "card_holder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardHolder {

  @Id
  private String dni;
  @Field("complete_name")
  private String completeName;
  private String cuil;
  private String address;
  private String telephone;
  private Date entry;
  @JsonIgnore
  @DBRef(lazy = true)
  private Set<Bank> banks = new HashSet<>(0);
  @JsonIgnore
  @DBRef(lazy = true)
  private Set<Card> cards = new HashSet<>(0);
}
