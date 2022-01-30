package com.platzi.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id   // se anota id porque es clave primaria estecampo, generated value porque es autogenerado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")    // @Column se anota cuando el campo no es el misno mombre que la tabla, se cambia cuando en la tabla tiene guien bajo y en java no se usa
    private Integer idProducto;

    private String nombre;   // si e nombre del campo sera igua al de la tabla no hace falta anotar

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column (name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne  // relacion muchos a uno
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)  // insertable yupdatabla false significa que no se va a borrar ni agregar desde esta relacion
    private Categoria categoria;  // La relacion de la tabla categoria con producto. muchos a uno

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean isEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
