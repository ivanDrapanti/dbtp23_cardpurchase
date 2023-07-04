package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quota {

  @Id
  @Column
  private String id;

  @Column
  private int number;

  @Column
  private float price;

  @Column
  private String month;

  @Column
  private String year;

  @ManyToOne
  @JoinColumn(name = "purchase")
  private MonthlyPayments purchase;

  @ManyToOne
  @JoinColumn(name = "payment")
  private Payment payment;
}
