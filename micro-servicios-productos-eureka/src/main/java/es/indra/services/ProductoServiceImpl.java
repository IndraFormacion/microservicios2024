/**
 * 
 */
package es.indra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.models.Producto;
import es.indra.persistence.ProductosDAO;

/**
 * 
 */
@Service
public class ProductoServiceImpl implements IProductoServices{
	
	@Autowired
	private ProductosDAO dao;
	
	@Override
	public List<Producto> consultarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Producto buscarProducto(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(new Producto());
	}

}
