package org.gerardo.taller.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "motocicleta")
public class Motocicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motocicleta_id", nullable = false)
    private Integer id;

    // llave foranea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id", nullable = false)
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

    // Relacion inversa, (una moto tiene muchas ordenes de servicio)
    @OneToMany(mappedBy = "motocicleta", cascade = CascadeType.ALL)
    private List<OrdenServicio> ordenesServicio;


    public Motocicleta() {
    }

    public Motocicleta(String placa, String van, int cilindrada, int year) {
        this.placa = placa;
        this.van = van;
        this.cilindrada = cilindrada;
        this.year = year;
    }

    public Motocicleta(Integer id, Cliente cliente, Modelo modelo, String placa, String van, int cilindrada, int year, LocalDateTime creadoEn, LocalDateTime modificadoEn) {
        this.id = id;
        this.cliente = cliente;
        this.modelo = modelo;
        this.placa = placa;
        this.van = van;
        this.cilindrada = cilindrada;
        this.year = year;
        this.creadoEn = creadoEn;
        this.modificadoEn = modificadoEn;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
