/**
 * 
 */
package es.indra.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.indra.models.Carrito;
import java.util.List;


/**
 * 
 */
@RepositoryRestResource(collectionResourceRel = "CARRITOS", path = "carritos")
public interface CarritosDAO extends MongoRepository<Carrito, String>{
	//URL para ver todos los carritos
	//http://localhost:8003/carritos
	
	//http://localhost:8003/carritos
	
	public Carrito findByUsuario(String usuario);

}
