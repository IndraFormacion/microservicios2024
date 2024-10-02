/**
 * 
 */
package es.indra.service;

import es.indra.models.Carrito;
import es.indra.models.Pedido;

/**
 * 
 */
public class CarritoServiceImpl implements CarritoService{

	@Override
	public Carrito crear(String usuario) {
		// TODO Auto-generated method stub
		Pedido pedido = new Pedido();
		Double importe= 0.0;
		return new Carrito(usuario,pedido,importe);
	}

	@Override
	public void agregarPedido(Long id, Integer cantidad, String usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carrito consultar(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPedido(Long id, String usuario) {
		// TODO Auto-generated method stub
		
	}

}
