/**
 * 
 */
package es.indra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import es.indra.models.Carrito;
import es.indra.service.CarritoService;

/**
 * 
 */
@RestController
public class CarritoREST {
	@Autowired
	private CarritoService service;
	// http://localhost:8003/crear/usuario1
	@PostMapping("/crear/{usuario}")
	public Carrito crear(@PathVariable String usuario) {
		return service.crear(usuario);
	}
	// http://localhost:8003/agregarPedidoidad/16/usuario/usuario1
	@PutMapping("/agregarPedido/{id}/cantidad/{cantidad}/usuario/{usuario}")
	public Carrito agregarPedido(@PathVariable Long id, @PathVariable Integer cantidad, @PathVariable String usuario) {
		return service.agregarPedido(id, cantidad, usuario);
	}
	// http://localhost:8003/consultar/usuario1
	@GetMapping("/consultar/{usuario}")
	public Carrito consultar(@PathVariable String usuario) {
		return service.consultar(usuario);
    }
	// http://localhost:8003/eliminar/1/usuario/usuario1
	@DeleteMapping("/eliminar/{id}/usuario/{usuario}")
	public Carrito eliminarPedido(@PathVariable Long id, @PathVariable String usuario) {
		return service.eliminarPedido(id, usuario);
    }
}
