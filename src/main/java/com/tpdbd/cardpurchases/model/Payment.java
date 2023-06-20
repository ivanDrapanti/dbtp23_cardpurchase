package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
  private Date firstExpiration;

  @Column
  private Date secondExpiration;

  @Column
  private float surchase;

  @Column
  private float totalPrice;

  @OneToMany (mappedBy = "id")
  private Set<Quota> quotasPayment;

  @OneToMany (mappedBy = "id")
  private Set<CashPayment> cashPayments;
}
