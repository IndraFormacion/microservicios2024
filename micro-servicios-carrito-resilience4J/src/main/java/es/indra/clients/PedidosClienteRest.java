/**
 * 
 */
package es.indra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.indra.models.Pedido;

/**
 * 
 */
@FeignClient(name="servicios-pedidos")
public interface PedidosClienteRest {
	
	@GetMapping("/buscar/{id}/cantidad/{cantidad}")
	public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad);
	
}
