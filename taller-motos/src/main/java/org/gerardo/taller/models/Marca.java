package org.gerardo.taller.models;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelo_id", nullable = false)
    private int id;

    @Column(nullable = false, length = 50)
    private String nombre;
}
