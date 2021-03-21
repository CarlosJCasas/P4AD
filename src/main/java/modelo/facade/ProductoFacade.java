package modelo.facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import controller.HibernateSessionController;
import modelo.vo.ProductoVO;
import modelo.vo.ProductosVO;

public class ProductoFacade {
	// Crear metodos para todas las transacciones con hibernate y su puta madre
	public static void addProducto(ProductoVO producto) {
		Session session = HibernateSessionController.openSessionFactory().openSession();
		session.beginTransaction();
		System.out.println(producto);
		session.save(producto);
		session.getTransaction().commit();
		System.out.println("Producto añadido?");
		HibernateSessionController.closeSessionFactory();
	}


	public static boolean deleteProducto(String referencia) {
		Session session = HibernateSessionController.openSessionFactory().openSession();
		session.beginTransaction();
		ProductoVO producto = (ProductoVO) session
				.createQuery("SELECT p FROM ProductoVO p WHERE p.referencia = '" + referencia + "'").uniqueResult();
		if (producto == null) {
			return false;
		}
		session.delete(producto);
		
		session.getTransaction().commit();
		HibernateSessionController.closeSessionFactory();
		return true;
	}
	
	public static ProductoVO buscarProducto(String referencia) {
		Session session = HibernateSessionController.openSessionFactory().openSession();
		session.beginTransaction();
		ProductoVO producto = (ProductoVO) session
				.createQuery("SELECT p FROM ProductoVO p WHERE p.referencia = '"+ referencia + "'").getSingleResult();
		session.getTransaction().commit();
		HibernateSessionController.closeSessionFactory();
		return producto;
	}

	public static DefaultTableModel listadoProductos() {
		String[] nombreColumnas = {"Referencia", "Nombre", "Descripción", "Cantidad", "Precio"};
		DefaultTableModel model = new DefaultTableModel(null, nombreColumnas);
		Session session = HibernateSessionController.openSessionFactory().openSession();
		session.beginTransaction();
		List<ProductoVO> productos = session.createQuery("SELECT p FROM ProductoVO p", ProductoVO.class).getResultList();
		for (ProductoVO producto : productos) {
			Object[] row = { producto.getReferencia(), producto.getNombre(), producto.getDescripcion(),
					producto.getCantidad(), producto.getPrecio() };
			model.addRow(row);
		}
		HibernateSessionController.closeSessionFactory();
		return model;
	}
	
	public static void importarProductos(String nombreXml) throws JAXBException, IOException {
		System.out.println("Pero entra aqui al menos?");
		JAXBContext jaxbContext = JAXBContext.newInstance(ProductosVO.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		File file = new File("src\\"+nombreXml+".xml");
		if(!file.exists()) file.createNewFile();
		ProductosVO listaProductos = (ProductosVO) unmarshaller.unmarshal(file);
		System.out.println("AQUI LLEGA?");
		if(!listaProductos.getProductos().isEmpty()) {
			System.out.println("Y AQUI?");
			for(ProductoVO prod : listaProductos.getProductos()) {
				Session session = HibernateSessionController.openSessionFactory().openSession();
				session.beginTransaction();
				session.save(prod);
				session.getTransaction().commit();
				HibernateSessionController.closeSessionFactory();
				System.out.println("se estan agregando los productos o que?");
			}
		}
	}
	
	public static void exportarProductos(String nombreXml) throws JAXBException {
		
		System.out.println("ENTRA AQUI?");
		Session session = HibernateSessionController.openSessionFactory().openSession();
		session.beginTransaction();
		
		List<ProductoVO> productos = session.createQuery("SELECT p FROM ProductoVO p", ProductoVO.class).getResultList();
		ArrayList<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
		listaProductos.addAll(productos);
		ProductosVO array = new ProductosVO();
		array.setProductos(listaProductos);
		
		JAXBContext context = JAXBContext.newInstance(ProductosVO.class);
		Marshaller marshall = context.createMarshaller();
		marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		FileWriter file;
		try {
			file = new FileWriter("src\\"+nombreXml+".xml");
			marshall.marshal(array, file);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		HibernateSessionController.closeSessionFactory();

	}
	
}
