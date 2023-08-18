package com.tpdbd.cardpurchases.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MonthlyPayments.class, name = "M"),
        @JsonSubTypes.Type(value = CashPayment.class, name = "C")
})
public abstract class Purchase {

  @Id
  private String id;
  @Field("payment_voucher")
  private String paymentVoucher;
  private String store;
  @Field("cuit_store")
  private String cuitStore;
  private float amount;
  @Field("final_amount")
  private float finalAmount;
  private Date date;
  @JsonIgnore
  @DBRef
  private Card card;
  private String type;
  @Field("valid_promotion")
  private Promotion validPromotion;

  @JsonProperty("card")
  public String getCardNumber() {
    return this.card != null ? this.card.getNumber() : null;
  }
}
