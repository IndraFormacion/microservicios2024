/**
 * 
 */
package es.indra.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * 
 */
public class Carrito implements Serializable{
	@Id
	private String id;
	private String usuario;
	private List<Pedido> contenido;
	private double importe;
	
	
	
	/**
	 * 
	 */
	public Carrito() {
	}
	
	/**
	 * @param usuario
	 * @param contenido
	 * @param importe
	 */
	public Carrito(String usuario, List<Pedido> contenido, double importe) {
		super();
		this.usuario = usuario;
		this.contenido = contenido;
		this.importe = importe;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the contenido
	 */
	public List<Pedido> getContenido() {
		return contenido;
	}
	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(List<Pedido> contenido) {
		this.contenido = contenido;
	}
	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario=" + usuario + ", contenido=" + contenido + ", importe=" + importe + "]";
	}
}
