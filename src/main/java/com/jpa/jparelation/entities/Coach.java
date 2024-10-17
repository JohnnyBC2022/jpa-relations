package com.jpa.jparelation.entities;


import jakarta.persistence.*;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Table(name="coach") si queremos otro nombre de tabla
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name") // Esto se hace para que SQL (snake_case) use este tipo de nombre y para Java como le hemos definido en su variable (camelCase)
    private String lastName;
    private String nationality;
    private Integer age;
}
