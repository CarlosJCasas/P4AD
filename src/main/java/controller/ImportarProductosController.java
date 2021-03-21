package controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import modelo.facade.ProductoFacade;
import vista.ImportarProductosVista;

public class ImportarProductosController extends ImportarProductosVista{

	@Override
	protected void importarProductos(String nombreXml) {
		try {
			String nombreFile = nombreXml;
			ProductoFacade.importarProductos(nombreFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
