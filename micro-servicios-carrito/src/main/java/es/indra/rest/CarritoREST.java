/**
 * 
 */
package es.indra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("")
	public Carrito crear(@PathVariable String usuario) {
		return service.crear(usuario);
	}
	public void agregarPedido(@PathVariable Long id, @PathVariable Integer cantidad, @PathVariable String usuario) {
		service.agregarPedido(id, cantidad, usuario);
	}
	public Carrito consultar(@PathVariable String usuario) {
		return service.consultar(usuario);
    }
	public void eliminarPedido(@PathVariable Long id, @PathVariable String usuario) {
    	service.eliminarPedido(id, usuario);
    }
}
