/**
 * 
 */
package es.indra.rest;

import java.net.Authenticator.RequestorType;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	
	
	//Capturar el puerto por el que entra la peticion
	//Con puerto dinamico esto no funciona utilizamos HttpServleyRequest
	//@Value("${server.port}")
	//private Integer port;
	
	//http://localhost:8001/listar
	@Autowired
	private HttpServletRequest request;
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
					//prod.setPort(port);
					prod.setPort(request.getLocalPort());
					return prod;
				})
				.collect(Collectors.toList());
		
	}
	//http://localhost:8001/buscar/ID
	@GetMapping("/buscar/{id}")
	public Producto buscar(@PathVariable Long id) throws InterruptedException{
		Producto producto = productoServices.buscarProducto(id);
		
		//Si no ha encontrado el producto la instancia estara vacia
		//lanzamos excepcion
		if(producto.getDescripcion()==null) {
			throw new RuntimeException("Error al buscar el producto");
		}
		//En Hystrix el timeout es de 1 segundo
		//lo podemos ampliar a 15 segundos Vamos apararlo 10 segundos
		/*if(id.equals(1L)) {
			Thread.sleep(3_000);
		}
		if(id.equals(2L)) {
			Thread.sleep(10_000);
		}*/
		producto.setPort(request.getLocalPort());
		return producto;
	}
}
