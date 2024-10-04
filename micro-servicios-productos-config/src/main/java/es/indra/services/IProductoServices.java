/**
 * 
 */
package es.indra.services;

import java.util.List;

import es.indra.models.Producto;

/**
 * 
 */
public interface IProductoServices {
	List<Producto> consultarTodos();
	Producto buscarProducto(Long id);
}
