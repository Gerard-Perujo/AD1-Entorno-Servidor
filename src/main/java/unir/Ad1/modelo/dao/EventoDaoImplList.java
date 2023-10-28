package unir.Ad1.modelo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import unir.Ad1.modelo.javabeans.Eventos;

@Repository
public class EventoDaoImplList implements EventosDao{
	
	private List<Eventos>listaEvento;
	private static int idAuto;
	
	static {
		idAuto = 0;
	}
	
	/**
	 * dento del constructor me creo una arrayList llamada listaEvento donde voy
	 * a entrar toda la lista de los diferentes eventos que tenemos y con cargarLista
	 * creo un metodo donde va a estar toda la lista con toda la informacion
	 */
	public EventoDaoImplList() {
		listaEvento = new ArrayList<>();
		cargarLista();
	}
	
	public void cargarLista() {
		
		TiposDaoImplList tipo = new TiposDaoImplList();
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			listaEvento.add(new Eventos(1,2,200,100,"Boda Jose", "Boda de la familia Jose con 100 invitados","Calle San Juan","Activo","S",data.parse("10-10-2022"),30500.99,tipo.buscarPorId(004)));
			listaEvento.add(new Eventos(2,3,200,50, "Cumpleaños Carla", "Cumpleaños al aire libre con inchables", "Calle Francisco nº1", "Activo", "N", data.parse("08-08-2024"), 512.30, tipo.buscarPorId(003)));
			listaEvento.add(new Eventos(3,3,200,50,"Despedida Eva", "Despedida soltera con Strepties", "Calle Juan III nº3","Activo","S",data.parse("10-06-2023"),845.20,tipo.buscarPorId(002)));
			listaEvento.add(new Eventos(4,5,200,190,"Concierto Caskets", "Concierto del Grupo Caskets en Gerona", "Montilibi", "Activo", "S", data.parse("09-03-2024"),40597.65,tipo.buscarPorId(001)));
			listaEvento.add(new Eventos(5,2,300,200,"Cumpleaños Jose", "Cumpleaños en recinto social", "Calle Jorge", "Activo", "S", data.parse("10-08-2021"),40597.65,tipo.buscarPorId(003)));
			listaEvento.add(new Eventos(6,5,300,250,"Boda Julia", "Boda en Pedralbes con 200 invitados", "Restaurante Can Roca", "Activo", "S", data.parse("24-08-2024"),40597.65,tipo.buscarPorId(004)));
			idAuto=6;
		}catch (ParseException e) {
			
		}
		

		
	}

	@Override
	public Eventos buscarPorId(int idEvento) {
		for(int i=0; i<listaEvento.size(); i++) {
			if(listaEvento.get(i).getIdEvento()== idEvento)
				return listaEvento.get(i);
		}
		return null;
	}
	/**
	 * Con una lista recorremos todos los eventos y devolvemos la lista con todos
	 * los eventos
	 */
	@Override
	public List<Eventos> buscarTodos() {
		return listaEvento;
	}

	/**
	 * Entra un objeto Eventos y nos devuelve un numero en caso de que el evento
	 * exista nos va a devolver un 0 y en caso de que no exista va añadir el evento a
	 * la lista y encima le pondra un id automaticamente
	 */
	@Override
	public int alta(Eventos evento) {
		if(!listaEvento.contains(evento)) {
			evento.setIdEvento(++idAuto);
			listaEvento.add(evento);
			return 1;
		}
		else
		return 0;
	}

	/**
	 * nos entra un int con el id del evento, creamos un objeto, y con el utilizamos
	 * el metodo findById para buscar si existe el objeto en question, en caso de que
	 * existiera este sera eliminado devolviendo un 1 y en caso de que no exista
	 * nos devolvera un 0
	 */
	@Override
	public int borrar(int idEvento) {
		Eventos even = buscarPorId(idEvento);
		if(even == null)
			return 0;
		return listaEvento.remove(even) ? 1 : 0;
		
	}

	/**
	 * Nos entra un objeto y va a devolver un int, en caso de que el objeto en question
	 * no existiera nos devolveria un 0 y en caso de que existiera nos va a devolver un 1
	 */
	@Override
	public int modificar(Eventos evento) {
		int pos = listaEvento.indexOf(evento);
			if(pos == -1)
				return 0;
			if (listaEvento.set(pos, evento) != null)
				return 1;
			return 0;
	}
	
	/**
	 * tengo la lista de Eventos, llamo al metodo stream y dentro del metodo stream
	 * llamo el metodo filter para que me filtre cada elemento de la lista y me coge 
	 * los elementos de la lista que esten activos y devuelvo la lista ya que nos entra
	 * una lista
	 */
	@Override
	public List<Eventos> buscarPorActivo() {
		return listaEvento
				.stream()
				.filter(ele -> ele.getEstado().equals("Activo"))
				.toList();
	}

	@Override
	public List<Eventos> buscarPorCancelado() {
		return listaEvento
				.stream()
				.filter(ele -> ele.getEstado().equals("Cancelado"))
				.toList();
	}
	
	
	
	

}
