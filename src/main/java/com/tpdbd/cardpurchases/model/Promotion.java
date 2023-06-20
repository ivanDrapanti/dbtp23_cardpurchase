package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.STRING,
        length = 1)
public abstract class Promotion {

  @Id
  @Column
  private String code;

  @Column
  private String promotionTitle;

  @Column
  private String nameStore;

  @Column
  private String cuitStore;

  @Column
  private Date validityStartDate;

  @Column
  private Date validityEndDate;

  @Column
  private String comments;

  @Column(name = "type", insertable = false, updatable = false)
  private String type;

  @OneToMany(mappedBy = "validPromotion",
          fetch = FetchType.LAZY,
          targetEntity = Purchase.class)
  private Set<Purchase> purchases;
}
