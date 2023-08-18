package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  @Id
  private String id;
  private String code;
  private String month;
  private String year;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Field("first_expiration")
  private Date firstExpiration;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Field("second_expiration")
  private Date secondExpiration;
  private float surcharge;
  @Field("total_price")
  private float totalPrice;
  @JsonIgnore
  @DBRef
  private Set<Quota> quotasPayment = new HashSet<>();
  @JsonIgnore
  @DBRef
  private Set<CashPayment> cashPayments = new HashSet<>();

  public void addQuota(Quota quota){
    quotasPayment.add(quota);
  }
  public void addCashPayment(CashPayment cashPayment){
    cashPayments.add(cashPayment);
  }
  @JsonProperty("quotas")
  public Set<String> getQuotas(){
    Set<String> ids = new HashSet<>();
    for (Quota quota : quotasPayment) {
      ids.add(quota.getId());
    }
    return ids;
  }
  @JsonProperty("cashPayments")
  public Set<String> getCashPayments(){
    Set<String> ids = new HashSet<>();
    for (CashPayment cashPayment : cashPayments) {
      ids.add(cashPayment.getId());
    }
    return ids;
  }
}
