package com.tpdbd.cardpurchases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Financing extends Promotion{

    @Field("number_of_quotas")
    private int numberOfQuotas;
    private float interest;

}
