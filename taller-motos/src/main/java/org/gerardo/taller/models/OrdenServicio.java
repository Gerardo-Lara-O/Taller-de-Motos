package org.gerardo.taller.models;

import jakarta.persistence.*;
import org.gerardo.taller.models.enums.StatusOrden;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orden_servicio")
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motocicleta_id", nullable = false)
    private Motocicleta motocicleta;

    @Column(name = "descripcion_problema", nullable = false)
    private String descripcionProblema;

    @Column(nullable = false)
    private double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private StatusOrden status = StatusOrden.OPEN; // le damos el valor por defecto

    @CreationTimestamp
    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn;

    @UpdateTimestamp
    @Column(name = "modificado_en")
    private LocalDateTime modificadoEn;

    // Una orden tiene muchos detalles
    @OneToMany(mappedBy = "ordenServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalles;

    public OrdenServicio() {
    }

    public OrdenServicio(String descripcionProblema, double total, StatusOrden status) {
        this.descripcionProblema = descripcionProblema;
        this.total = total;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }

    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public StatusOrden getStatus() {
        return status;
    }

    public void setStatus(StatusOrden status) {
        this.status = status;
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

    public List<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrden> detalles) {
        this.detalles = detalles;
    }
}
