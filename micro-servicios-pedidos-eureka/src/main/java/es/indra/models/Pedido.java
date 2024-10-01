/**
 * 
 */
package es.indra.models;

/**
 * 
 */
public class Pedido {
	private Producto producto;
	private int cantidad;
	/**
	 * 
	 */
	public Pedido() {
		super();
	}
	/**
	 * @param producto
	 * @param cantidad
	 */
	public Pedido(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
