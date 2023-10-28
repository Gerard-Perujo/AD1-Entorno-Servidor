package unir.Ad1.modelo.dao;

import java.util.List;

import unir.Ad1.modelo.javabeans.Tipos;

/*
 * En esta interface solo vamos a implementar 2 metodos que son los que nos 
 * piden un:
 * findAll para recorrer todos los tipos diferentes de eventos que tenemos
 * findById para encontrar un tipo en concreto
 */
public interface TiposDao {
	
	List <Tipos> buscarTodos();
	Tipos buscarPorId (int idTipos);
}
