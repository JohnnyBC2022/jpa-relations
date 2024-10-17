package com.jpa.jparelation.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Relación 1 a 1. Con targetEntity le decimos que la relación va a ser con la clase Coach.
    // Con el comportamiento en cascada le estamos diciendo lo que va a pasar en la tabla Coach cuando hagamos cambios
    // en la tabla Club. En este caso, le estamos diciendo que si eliminamos un Club, el entrenador va a seguir existiendo
    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coach") // Con esta anotación podemos personaliza el nombre de la clave foránea
    private Coach coach;

    // El tipo de fetch es para el comportamiento de traer los datos de las otras tablas.
    // FetchType lazy es para que traiga los datos de los jugadores cuando yo se lo diga.
    // Con Eager se trae Inmediatamente el listado
    // En este tipo de relación JPA no debe crear una tabla adiccional, para eso debemos propagar la clave foránea.
    // Es decir, le estamos indicando en la clase Player que la clave foránea es club (línea 26 de Player)
    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club") // 1 a muchos porque un Club tiene muchos jugadores
    private List<Player> players;

    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;

    // Para personalizar esta tabla de relación, podemos usar JoinTable.
    // name: nombre de la tabla
    // joinColumns: me permite modificar la clave foránea que va a tener el club (columna club_id)
    // inverseJoinColumns: me permite modifica la clave foránea de la relación inversa (columna football_competitions_id)
    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition"))
    private List<FootballCompetition> footballCompetitions;
}
