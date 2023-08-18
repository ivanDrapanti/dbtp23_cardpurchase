package com.tpdbd.cardpurchases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount extends Promotion{

    @Field("discount_percentage")
    private Float discountPercentage;
    @Field("price_cap")
    private Float priceCap;
    @Field("only_cash")
    private Boolean onlyCash;
}
