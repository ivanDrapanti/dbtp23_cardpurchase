package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Document(collection = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

  @Id
  private String id;
  private String number;
  private String ccv;
  @Field("card_holder_name_in_card")
  private String cardHolderNameInCard;
  private Date since;
  @Field("expiration_date")
  private Date expirationDate;
  @JsonIgnore
  @DBRef
  private Bank bank;
  @JsonIgnore
  @DBRef
  @Field("card_holder")
  private CardHolder cardHolder;
  @JsonIgnore
  @DBRef(lazy = true)
  private List<Purchase> purchases;
  @JsonProperty("purchases")
  public Set<String> getPurchasesByIds() {
    Set<String> ids = new HashSet<>();
    for (Purchase purchase : purchases) {
      ids.add(purchase.getId());
    }
    return ids;
  }
}
