package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("D")
public class Discount extends Promotion{

    @Column
    private Float discountPercentage;

    @Column
    private Float priceCap;

    @Column
    private Boolean onlyCash;

}
