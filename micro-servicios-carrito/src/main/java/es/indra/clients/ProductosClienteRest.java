/**
 * 
 */
package es.indra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.indra.models.Producto;
/**
 * 
 */
@FeignClient(name="servicios-productos")
public interface  ProductosClienteRest {
	@PostMapping("/añadir")
	public Producto add(@PathVariable Long id);
}
