package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
* @Repository: le indicamos a la clase que es la encarga de interactuar con la base de datos.
@Component: le indicamos que es un componente de spring.

El primero es mejor porque indicamos el tipo de componente que es.
*
* Esta anotación siempre debe ir en la implementación de la interfaz.
* */
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
/*
* Se utiliza Optional para definir un objeto que puede (o no) tener contenido,
* en el caso de la función getEscasos, si todos los productos tuvieran un stock alto, la consulta no traería resultados.

En el curso de programación funcional con java explican este tema.
*
* */
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    public List<Producto> getPreciosBajos(int precioBajo){
        return productoCrudRepository.getByPrecioVentaLessThan(precioBajo);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }


}
