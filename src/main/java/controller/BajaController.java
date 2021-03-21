package controller;

import modelo.facade.ProductoFacade;
import vista.BajaVista;

public class BajaController extends BajaVista{
		
	public BajaController() {
		
	}

	

	@Override
	protected boolean deleteProducto(String referencia) {
		return ProductoFacade.deleteProducto(referencia);
	}
	
}
