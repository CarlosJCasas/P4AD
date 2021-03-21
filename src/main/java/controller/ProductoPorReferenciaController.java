package controller;

import modelo.facade.ProductoFacade;
import modelo.vo.ProductoVO;
import vista.ProductoPorReferenciaVista;

public class ProductoPorReferenciaController extends ProductoPorReferenciaVista{

	@Override
	protected ProductoVO buscarPorRefencia(String referencia) {
		return ProductoFacade.buscarProducto(referencia);
	}

	
	
}
