package com.tpdbd.cardpurchases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document(collection = "purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyPayments extends Purchase {

  private float interest;
  @Field("number_of_quotas")
  private int numberOfQuotas;

  @DBRef(lazy = true)
  private Set<Quota> quotas;

}
