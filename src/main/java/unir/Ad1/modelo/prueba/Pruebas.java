package unir.Ad1.modelo.prueba;

import unir.Ad1.modelo.dao.EventoDaoImplList;
import unir.Ad1.modelo.javabeans.Eventos;

public class Pruebas {

	public static void main(String[] args) {
		
		EventoDaoImplList evenda = new EventoDaoImplList();
		
		
		System.out.println(evenda.buscarPorCancelado());

	}
	public int modificarCancelado(int idEvento) {
		Eventos even = new Eventos();
		EventoDaoImplList evenda = new EventoDaoImplList();
		even = evenda.buscarPorId(idEvento);
		even.setEstado("Cancelado");
		if(evenda.modificar(even) == 1) {
			return 1;
		}else
			return 0;
	}
}
