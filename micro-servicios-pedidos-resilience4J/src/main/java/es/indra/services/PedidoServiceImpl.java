/**
 * 
 */
package es.indra.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.indra.clients.ProductosClienteRest;
import es.indra.models.Pedido;
import es.indra.models.Producto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

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
	
	@CircuitBreaker(name="pedidos",fallbackMethod = "manejarError2")
	@TimeLimiter(name="pedidos")
	public CompletableFuture<Pedido> crearPedido2(Long id, int cantidad) {
		Producto producto = clienteFeign.buscar(id);
		Pedido pedido= new Pedido(producto, cantidad);
		return CompletableFuture.supplyAsync(()->pedido);
	}
	
	public CompletableFuture<Pedido> manejarError2(Long id, int cantidad, Throwable ex) {
		System.out.println(ex.getMessage()+ "***************");
		System.out.println(ex.getClass()+ "---------------");
		Producto producto = new Producto();
		producto.setID(id);
		producto.setDescripcion("Producto lento");
		producto.setPrecio(0);
		
		return CompletableFuture.supplyAsync(()-> new Pedido(producto, cantidad));
	}
}
