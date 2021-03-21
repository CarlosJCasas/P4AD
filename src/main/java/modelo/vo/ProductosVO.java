package modelo.vo;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductosVO {
private List<ProductoVO> productos;
	public ProductosVO() {
		super();
		
	}
	public ProductosVO(List<ProductoVO> productos) {
		super();
		this.productos = productos;
	}
	public List<ProductoVO> getProductos() {
		return productos;
	}
	@XmlElement(name = "producto")
	public void setProductos(List<ProductoVO> productos) {
		this.productos = productos;
	}
	
	
}
