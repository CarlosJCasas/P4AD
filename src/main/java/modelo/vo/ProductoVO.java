package modelo.vo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@Entity
@Table(name="producto")
@XmlType(propOrder = {"referencia", "nombre", "descripcion", "cantidad", "precio"})
@XmlRootElement
public class ProductoVO implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String referencia;
	private String nombre;
	private String descripcion;
	private int cantidad;
	private double precio;
	
	public ProductoVO() {
		
	}

	public ProductoVO(String referencia, String nombre, String descripcion, int cantidad, double precio) {
		
		
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "REFERENCIA")
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column(name = "CANTIDAD")
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Column(name = "PRECIO")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto \nReferencia: " + referencia + "\nNombre: " + nombre + "\nDescripcion:" + descripcion
				+ "\nCantidad: " + cantidad + "\nPrecio: " + precio +" €";
	}
	
	
	
	
}
