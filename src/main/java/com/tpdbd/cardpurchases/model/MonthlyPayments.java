package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("M")
public class MonthlyPayments extends Purchase {

  @Column
  private float interest;

  @Column
  private int numberOfQuotas;

  @OneToMany(mappedBy = "purchase",
          fetch = FetchType.LAZY,
          targetEntity = Quota.class
  )
  private Set<Quota> quotas;
}
