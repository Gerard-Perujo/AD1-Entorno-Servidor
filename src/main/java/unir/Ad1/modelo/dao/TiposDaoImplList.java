package unir.Ad1.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import unir.Ad1.modelo.javabeans.Tipos;


@Repository
public class TiposDaoImplList implements TiposDao{
	
	private List<Tipos>listaTipo;
	
	public TiposDaoImplList() {
		listaTipo = new ArrayList<>();
		cargarLista();
	}
	/**
	 * Creamos un metodo llamado cargarLista donde vamos a tener toda la informacion
	 * de cada uno de los tipos de eventos que vamos a tener
	 
	 */
	public void cargarLista() {
		listaTipo.add(new Tipos(001, "Concierto","Concierto acustico al aire libre"));
		listaTipo.add(new Tipos(002, "Despedida", "Despedidas de solteros/a"));
		listaTipo.add(new Tipos(003, "Cumpleaños", "Cumpleaños con catering al aire libre"));
		listaTipo.add(new Tipos(004, "Boda", "Recepcion al exterior y comida al interior"));
		
	}
	
	@Override
	public List<Tipos> buscarTodos() {
	
		return listaTipo;
	}
	
	
	@Override
	public Tipos buscarPorId(int idTipos) {
		for (int i = 0; i < listaTipo.size(); i++) {
			if(listaTipo.get(i).getIdTipo() == idTipos)
				return listaTipo.get(i);
		}
		return null;
	}

}
