/**
 * 
 */
package es.indra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.indra.clients.ProductosClienteRest;
import es.indra.models.Pedido;
import es.indra.models.Producto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * 
 */
@Service
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private ProductosClienteRest clienteFeign;

	//En el caso de recibir una excepcion llamamos al metodo alternativo manejarError
	@Override
	//@HystrixCommand(fallbackMethod = "manejarError")
	@CircuitBreaker(name="pedidos",fallbackMethod = "manejarError")
	public Pedido crearPedido(Long id, int cantidad) {
		Producto producto = clienteFeign.buscar(id);
		return new Pedido(producto, cantidad);
	}
	
	//El metodo alternativo debe tener la misma declacrion que el original
	//devuelve el mismo tipo y recibe los mismos parametros
	public Pedido manejarError(Long id, int cantidad, Throwable ex) {
		System.out.println(ex.getMessage()+ "***************");
		System.out.println(ex.getClass()+ "---------------");
		Producto producto = new Producto();
		producto.setID(id);
		producto.setDescripcion("Producto vacio");
		producto.setPrecio(0);
		
		return new Pedido(producto, cantidad);
	}
}
