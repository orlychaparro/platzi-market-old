package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*
* Obs.: Si ProdcutCrudRepository se creo como una interfaz ¿Por que nunca se llego a implementar, sino que se trato como una clase?
*Inyectamos ProductCrudRepository en el Repository y lo usamos directamente porque extiende de CrudRepository,
*que es una funcionalidad que nos brinda Spring Data para interactuar con la base de datos sin necesidad de implementar. ¡Únicamente tenemos que utilizarla!
*Lo implementa Spring a través de la inversión de dependencia.
*
* */

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {  // La clase Entity relacinada Producto, y el tipo de la clave primaria Intenger
   // ejemplo con anotacion Query
   // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", NATIVEqUERY = TRUE)
   // List<Producto> getByCategoria(int idProducto);

 //   List<Producto> findByIdProducto(int idProducto);
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    List<Producto> getByPrecioVentaLessThan(double precioVenta);


}
