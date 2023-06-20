package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("D")
public class Discount extends Promotion{

    @Column
    private float discountPercentage;

    @Column
    private float priceCap;

    @Column
    private boolean onlyCash;

}
