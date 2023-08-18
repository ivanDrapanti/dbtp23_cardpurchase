package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Document(collection = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Discount.class, name = "D"),
        @JsonSubTypes.Type(value = Financing.class, name = "F")
})
public class Promotion {

  @Id
  private String id;
  private String code;
  @Field("promotion_title")
  private String promotionTitle;
  @Field("name_store")
  private String nameStore;
  @Field("cuit_store")
  private String cuitStore;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Field("validity_start_date")
  private Date validityStartDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Field("validity_end_date")
  private Date validityEndDate;
  private String comments;
  private String type;
  @JsonIgnore
  @DBRef
  private Set<Purchase> purchases;
  @JsonIgnore
  @DBRef
  private Bank bank;
  @JsonProperty("bank")
  public String getBankId() {
    return this.bank != null ? this.bank.getCuit() : null;
  }
}
