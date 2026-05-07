package org.gerardo.taller.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "motocicleta")
public class Motocicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motocicleta_id", nullable = false)
    private int id;

    // llave foranea
    private Cliente cliente;

    // llave foranea
    private Modelo modelo;

    @Column(length = 15)
    private String placa;
    @Column(length = 30)
    private String van;
    private int cilindrada;
    private int year;

    @CreationTimestamp
    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn;

    @UpdateTimestamp
    @Column(name = "modificado_en")
    private LocalDateTime modificadoEn;
}
