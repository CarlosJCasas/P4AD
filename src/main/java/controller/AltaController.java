package controller;


import modelo.facade.ProductoFacade;
import modelo.vo.ProductoVO;
import vista.AltaVista;

public class AltaController extends AltaVista{

	@Override
	protected void addProducto(String ref, String nom, String desc, int cant, double prec) {
		// TODO Auto-generated method stub
		
		ProductoVO producto = new ProductoVO(ref, nom, desc, cant, prec);
		ProductoFacade.addProducto(producto);
	}

}
