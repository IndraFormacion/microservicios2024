/**
 * 
 */
package es.indra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.indra.models.Producto;
import es.indra.services.IProductoServices;

/**
 * 
 */
@RestController
public class ProductoRest {
	
	@Autowired
	private IProductoServices productoServices;
	//http://localhost:8001/listar
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoServices.consultarTodos();
	}
	//http://localhost:8001/buscar/ID
	@GetMapping("/buscar/{id}")
	public Producto buscar(@PathVariable Long id){
		return productoServices.buscarProducto(id);
	}
}
