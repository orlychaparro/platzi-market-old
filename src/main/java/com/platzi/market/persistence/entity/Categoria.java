package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;
    @OneToMany(mappedBy = "categoria")   // se anota la relacion one to may y se mapea con categoria que secreo en Producto Many to one.
    private List<Producto> productos;  // se crea un tipo List de productos



    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
