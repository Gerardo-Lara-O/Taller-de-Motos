package org.gerardo.taller.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", nullable = false)
    private OrdenServicio ordenServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private ItemCatalogo itemCatalogo;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, name = "precio_historico")
    private double precioHistorico;

    public DetalleOrden() {
    }

    public DetalleOrden(ItemCatalogo itemCatalogo, int cantidad, double precioHistorico) {
        this.itemCatalogo = itemCatalogo;
        this.cantidad = cantidad;
        this.precioHistorico = precioHistorico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public ItemCatalogo getItemCatalogo() {
        return itemCatalogo;
    }

    public void setItemCatalogo(ItemCatalogo itemCatalogo) {
        this.itemCatalogo = itemCatalogo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioHistorico() {
        return precioHistorico;
    }

    public void setPrecioHistorico(double precioHistorico) {
        this.precioHistorico = precioHistorico;
    }
}
