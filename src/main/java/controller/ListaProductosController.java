package controller;

import javax.swing.table.DefaultTableModel;

import modelo.facade.ProductoFacade;
import vista.ListaProductosVista;

public class ListaProductosController extends ListaProductosVista{

	@Override
	protected DefaultTableModel listaProductos() {
		// TODO Auto-generated method stub
		return ProductoFacade.listadoProductos();
	}
	

}
