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

    // Relacion con Cliente (Muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente cliente;

    // Relacion con Modelo (Muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @Column(length = 15)
    private String placa;
    @Column(length = 30)
    private String vin;
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
        this.vin = van;
        this.cilindrada = cilindrada;
        this.year = year;
    }

    public Motocicleta(Integer id, Cliente cliente, Modelo modelo, String placa, String van, int cilindrada, int year, LocalDateTime creadoEn, LocalDateTime modificadoEn) {
        this.id = id;
        this.cliente = cliente;
        this.modelo = modelo;
        this.placa = placa;
        this.vin = van;
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getModificadoEn() {
        return modificadoEn;
    }

    public void setModificadoEn(LocalDateTime modificadoEn) {
        this.modificadoEn = modificadoEn;
    }

    public List<OrdenServicio> getOrdenesServicio() {
        return ordenesServicio;
    }

    public void setOrdenesServicio(List<OrdenServicio> ordenesServicio) {
        this.ordenesServicio = ordenesServicio;
    }
}
