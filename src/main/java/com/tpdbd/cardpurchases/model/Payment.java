package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  @Id
  @Column
  private String code;

  @Column
  private String month;

  @Column
  private String year;

  @Column
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date firstExpiration;

  @Column
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date secondExpiration;

  @Column
  private float surcharge;

  @Column
  private float totalPrice;

  @OneToMany (mappedBy = "id")
  @JsonIgnore
  private Set<Quota> quotasPayment = new HashSet<>();

  @OneToMany (mappedBy = "id")
  @JsonIgnore
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
