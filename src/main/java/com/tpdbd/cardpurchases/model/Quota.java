package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true)
  private long id;

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
  @JsonIgnore
  private MonthlyPayments purchase;

  @ManyToOne
  @JoinColumn(name = "payment")
  @JsonIgnore
  private Payment payment;
}
