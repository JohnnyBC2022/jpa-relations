package com.jpa.jparelation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Le podemos definir desde JPA el tipo de dato que va a recibir
    @Column(name = "name", columnDefinition = "VARCHAR(300)")
    private String name;

    // Con length le indicamos el máximo de caracteres que va a admitir esa columna
    // Con nullable si es un campo obligatorio
    // Con unique evitamos que sean valores duplicados
    // Con insertable le diríamos que no se puede insertar ningún valor
    // Updatable si se se puede actualizar
    @Column(name = "cuantity_price")
    private Integer cuantityPrice;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    // En la relación muchos a mucho no necesitamos el MappedBy ya que si queremos que se cree una tabla intermedia que
    // relacionará las muchas competiciones que pueden jugar muchos clubes
    // Si hacemos la relación en ambas tablas JPA creará 2 tablas intermedias. Como solo queremos una,
    // Con hacer la relación en una de las tablas es suficiente
    // @ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY)
    // private List<Club> clubs;
}
