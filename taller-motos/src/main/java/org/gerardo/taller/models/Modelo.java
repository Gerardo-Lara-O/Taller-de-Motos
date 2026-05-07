package org.gerardo.taller.models;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelo_id", nullable = false)
    private int id;

    // aqui va llave foranea
    private Marca marca;

    @Column(nullable = false, length = 50)
    private String nombre;
}
