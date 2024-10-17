package com.jpa.jparelation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String nationality;
    private Integer age;
    private String position;

    @ManyToOne(targetEntity = Club.class) //ManytoOne porque hay muchos jugadores en 1 club
    private Club club;
}
