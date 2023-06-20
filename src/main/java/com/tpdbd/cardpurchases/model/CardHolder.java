package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cardHolder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardHolder {

    @Id
    @Column
    private String dni;
    @Column
    private String completeName;
    @Column
    private String cuil;
    @Column
    private String address;
    @Column
    private String telephone;
    @Column
    private Date entry;
    @ManyToMany
    private Set<Bank> banks;
}
