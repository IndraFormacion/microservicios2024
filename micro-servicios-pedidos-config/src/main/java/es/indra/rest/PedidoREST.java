/**
 * 
 */
package es.indra.rest;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.indra.models.Pedido;
import es.indra.services.IPedidoService;

/**
 * 
 */
@RestController
public class PedidoREST {


	@Autowired
	private IPedidoService service;
	
	// localhost:8002/buscar/4/cantidad/100
	@GetMapping("/buscar/{id}/cantidad/{cantidad}")
	public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad) {
		return service.crearPedido(id, cantidad);
	}
	// localhost:8002/buscar2/4/cantidad/100
		@GetMapping("/buscar2/{id}/cantidad/{cantidad}")
		public CompletableFuture<Pedido> crearPedido2(@PathVariable Long id, @PathVariable int cantidad) {
			return service.crearPedido2(id, cantidad);
		}
}
