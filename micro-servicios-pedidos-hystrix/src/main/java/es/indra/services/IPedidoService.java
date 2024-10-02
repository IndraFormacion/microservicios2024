/**
 * 
 */
package es.indra.services;

import es.indra.models.Pedido;

/**
 * 
 */
public interface IPedidoService {
	Pedido crearPedido(Long id, int cantidad);
}
