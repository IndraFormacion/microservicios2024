/**
 * 
 */
package es.indra.services;

import java.util.concurrent.CompletableFuture;

import es.indra.models.Pedido;

/**
 * 
 */
public interface IPedidoService {
	Pedido crearPedido(Long id, int cantidad);
	CompletableFuture<Pedido> crearPedido2(Long id, int cantidad);
}
