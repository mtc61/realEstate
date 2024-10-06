package com.talhacelik.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROPERTIES")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "PROPERTY_NAME")
    String propertyName;

    @Column(name = "TITLE", length = 150)
    String title;

    @Column(name = "DESCRIPTON", length = 200)
    String description;

    @Column(name = "TYPE", length = 50)
    String type;

    private BigDecimal price;
    private int bedroom;
    private int bathroom;
    private float area;
    private String location;

    //  many          1
    // Property     Agent
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    //  many          1
    // Property     Seller
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    // m          m
    // Property  Buyer
    @ManyToMany
    @JoinTable(name = "Property_Buyer",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id"))

    private Set<Buyer> buyers = new HashSet<>();
}
