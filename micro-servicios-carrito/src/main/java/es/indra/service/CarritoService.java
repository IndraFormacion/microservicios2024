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
    void agregarPedido(Long id, Integer cantidad, String usuario);
    Carrito consultar(String usuario);
    void eliminarPedido(Long id, String usuario);
}
