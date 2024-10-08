/**
 * 
 */
package es.indra.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.indra.models.Producto;

/**
 * 
 */
@RepositoryRestResource(collectionResourceRel = "PRODUCTOS", path = "productos")
public interface ProductosDAO  extends JpaRepository<Producto, Long>{
	// Consultar todos los productos
	// http://localhost:8001/productos
	
	// Consultar los productos por ID
	// http://localhost:8001/productos/ID
	
	// Podemos crear nuestros metodos personalizados utilizando las keywords
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

	// Buscar productos por su descripcion
	// http://localhost:8001/productos/search/findByDescripcion?descripcion=Pantalla
	public List<Producto> findByDescripcion(String descripcion);

	// Todos los productos ordeandos por precio
	// http://localhost:8001/productos/search/OrderByPrecio
	public List<Producto> OrderByPrecio();


	// Todos los productos entre un rango de precios
	// http://localhost:8001/productos/search/findByPrecioBetween?min=50&max=200
	public List<Producto> findByPrecioBetween(double min, double max);
}
