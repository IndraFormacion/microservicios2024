/**
 * 
 */
package es.indra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.indra.models.Producto;

/**
 * 
 */
//@FeignClient(url="localhost:8001", name="servicios-productos")
//Al utilizar ribbon emito peticiones a las 2 instancias declaradas en el application.properties
@FeignClient(name="servicios-productos")
public interface ProductosClienteRest {
	@GetMapping("/buscar/{id}")
	public Producto buscar(@PathVariable Long id);
}
