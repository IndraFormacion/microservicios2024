/**
 * 
 */
package es.indra.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.indra.models.Producto;
import es.indra.services.IProductoServices;
import net.bytebuddy.asm.Advice.Return;

/**
 * 
 */
@RestController
public class ProductoRest {
	
	@Autowired
	private IProductoServices productoServices;
	
	//Capturar el puerto por el que entra la peticion
	@Value("${server.port}")
	private Integer port;
	
	//http://localhost:8001/listar
	@GetMapping("/listar")
	public List<Producto> listar(){
		 
		 /* Opcion 1
		 List<Producto> lista = productoServices.consultarTodos();
		 for(Producto producto:lista) {
			 producto.setPort(port);
		 }
		  return lista;
		 */
		 //Opcion 2 --> A partir de Java 8 podemos utilizar streams
		// Opcion 2 -> A partir de Java 8 podemos utilizar streams
		return productoServices.consultarTodos()
				.stream()
				.map(prod -> {
					prod.setPort(port);
					return prod;
				})
				.collect(Collectors.toList());
		
	}
	//http://localhost:8001/buscar/ID
	@GetMapping("/buscar/{id}")
	public Producto buscar(@PathVariable Long id){
		Producto producto = productoServices.buscarProducto(id);
		producto.setPort(port);
		return producto;
	}
}
