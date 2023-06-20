package com.tpdbd.cardpurchases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @Column
    private String cuit;
    @Column(name = "bank_name") //name is reserved by MySQL
    private String name;
    @Column
    private String address;
    @Column
    private String telephone;
    @Column
    private String direction;
    @ManyToMany
    private Set<CardHolder> members;
}
