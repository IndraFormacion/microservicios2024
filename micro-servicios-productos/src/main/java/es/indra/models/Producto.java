/**
 * 
 */
package es.indra.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long ID;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="PRECIO")
	private double precio;
	
	public Producto() {
	}

	/**
	 * @param descripcion
	 * @param precio
	 */
	public Producto(String descripcion, double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
	 * @return the iD
	 */
	public Long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Long iD) {
		ID = iD;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [ID=" + ID + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
	
	
}
