package unir.Ad1.modelo.dao;

import java.util.List;

import unir.Ad1.modelo.javabeans.Eventos;

/**
 * Creo una interface del javabeans evento con los metodos que voy a necesitar
 * para realizar todas las acciones que voy hacer:
 * 
 * un findById para encontrar un evento en concreto
 * una lista para recorrer todos los eventos
 * un alta para poder agregar un nuevo evento
 * un borrar para poder borrar un evento concreto
 * un modificiar para poder modificar un evento
 * 
 * @author Gerard Perujo
 *
 */

public interface EventosDao {
	
	Eventos buscarPorId (int idEvento);
	List <Eventos> buscarPorActivo();
	List <Eventos> buscarPorCancelado();
	List <Eventos> buscarTodos();
	int alta (Eventos evento);
	int borrar (int idEvento);
	int modificar(Eventos evento);

}
