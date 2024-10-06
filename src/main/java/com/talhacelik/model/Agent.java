package com.talhacelik.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AGENTS")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    Long id;

    @Column(name = "AGENT_NAME")
    String agentName;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "PHONE")
    String phone;

    @Column(name = "OFFICE_ADDRESS")
    String officeAddress;


    // 1          m
    // Agent   Property
    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Property> properties = new HashSet<>();

}
