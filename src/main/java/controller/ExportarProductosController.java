package controller;

import javax.xml.bind.JAXBException;

import modelo.facade.ProductoFacade;
import vista.ExportarProductosVista;

public class ExportarProductosController extends ExportarProductosVista{

	@Override
	protected void exportarProductos(String nombreXml) {
		try {
			ProductoFacade.exportarProductos(nombreXml);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
