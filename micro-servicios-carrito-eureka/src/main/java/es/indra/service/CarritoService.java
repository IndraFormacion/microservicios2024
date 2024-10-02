/**
 * 
 */
package es.indra.service;

import es.indra.models.Carrito;

/**
 * 
 */
public interface CarritoService {
	Carrito crear(String usuario);
	Carrito agregarPedido(Long id, Integer cantidad, String usuario);
    Carrito consultar(String usuario);
    Carrito eliminarPedido(Long id, String usuario);
}
