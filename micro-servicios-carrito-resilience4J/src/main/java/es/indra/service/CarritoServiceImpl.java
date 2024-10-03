/**
 * 
 */
package es.indra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.clients.PedidosClienteRest;
import es.indra.models.Carrito;
import es.indra.models.Pedido;
import es.indra.persistence.CarritosDAO;

/**
 * 
 */
@Service
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	private CarritosDAO dao;
	@Autowired
	private PedidosClienteRest clienteFeign;
	@Override
	public Carrito crear(String usuario) {
		// TODO Auto-generated method stub
		Carrito carrito = consultar(usuario);
		if(carrito==null) {
			carrito= new Carrito();
			carrito.setUsuario(usuario);
			carrito= dao.save(carrito);
		}
		
		
		return carrito;
	}

	@Override
	public Carrito agregarPedido(Long id, Integer cantidad, String usuario) {
		// TODO Auto-generated method stub
		Pedido pedido = clienteFeign.crearPedido(id, cantidad);
		Carrito carrito = consultar(usuario);
		carrito.getContenido().add(pedido);
		double importe = carrito.getImporte() + (pedido.getProducto().getPrecio()*cantidad);
		carrito.setImporte(importe);
		return dao.save(carrito);
		
	}

	@Override
	public Carrito consultar(String usuario) {
		// TODO Auto-generated method stub
		return dao.findByUsuario(usuario);
	}

	@Override
	public Carrito eliminarPedido(Long id, String usuario) {
		// TODO Auto-generated method stub
		Carrito carrito = consultar(usuario);
		List<Pedido> contenido = carrito.getContenido();
		Pedido encontrado = null;
		for(Pedido pedido: contenido) {
			if(id.equals(pedido.getProducto().getID())) {
				encontrado= pedido;
				break;
			}
		}
		contenido.remove(encontrado);
		double importe = carrito.getImporte()- (encontrado.getProducto().getPrecio()*encontrado.getCantidad());
		carrito.setImporte(importe);
		return dao.save(carrito);
	}

}
