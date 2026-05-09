package org.gerardo.taller.models;

import jakarta.persistence.*;
import org.gerardo.taller.models.enums.TipoItem;

@Entity
@Table(name = "item_catalogo")
public class ItemCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoItem tipo;

    @Column(name = "codigo_sku", length = 50)
    private String codigoSku;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(name = "precio_base", nullable = false)
    private double precioBase;

    public ItemCatalogo() {
    }

    public ItemCatalogo(TipoItem tipo, String codigoSku, String descripcion, double precioBase) {
        this.tipo = tipo;
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
