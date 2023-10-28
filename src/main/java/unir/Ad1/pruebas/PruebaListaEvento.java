package unir.Ad1.pruebas;

import unir.Ad1.modelo.dao.EventoDaoImplList;

public class PruebaListaEvento {

	public static void main(String[] args) {
		
		EventoDaoImplList cdao = new EventoDaoImplList();
		
	
		
		System.out.println(cdao.buscarTodos());
	}

}
