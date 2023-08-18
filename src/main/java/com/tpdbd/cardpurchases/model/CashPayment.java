package com.tpdbd.cardpurchases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CashPayment extends Purchase{

    @Field("store_discount")
    private float storeDiscount;
}
