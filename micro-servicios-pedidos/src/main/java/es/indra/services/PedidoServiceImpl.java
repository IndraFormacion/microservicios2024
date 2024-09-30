/**
 * 
 */
package es.indra.services;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.clients.ProductosClienteRest;
import es.indra.models.Pedido;
import es.indra.models.Producto;

/**
 * 
 */
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private ProductosClienteRest clienteFeign;

	@Override
	public Pedido crearPedido(Long id, int cantidad) {
		Producto producto = clienteFeign.buscar(id);
		return new Pedido(producto, cantidad);
	}
	
	
}
