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

@Document(collection = "quota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quota {

  @Id
  private String id;
  private int number;
  private float price;
  private String month;
  private String year;
  @JsonIgnore
  @DBRef
  @Field("monthly_payments")
  private MonthlyPayments monthlyPayments;
  @JsonIgnore
  @DBRef
  private Payment payment;
}
