package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
  private Set<Quota> quotasPayment;

  @OneToMany (mappedBy = "id")
  private Set<CashPayment> cashPayments;
}
