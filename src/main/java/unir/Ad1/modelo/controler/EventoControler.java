package unir.Ad1.modelo.controler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import unir.Ad1.modelo.dao.EventosDao;
import unir.Ad1.modelo.javabeans.Eventos;

@Controller
@RequestMapping("/eventos")
public class EventoControler {
	
	@Autowired
	private EventosDao evendao;
	Eventos eventos = new Eventos();
	
	@GetMapping("/cancelados")
	public String mostrarCancelados(Model model) {
		model.addAttribute("eventos", evendao.buscarPorCancelado());
		return "cancelados";		
	
	}
	
	@GetMapping("/detalle/{id}")
	public String mostrarDetalles(@PathVariable("id") int idEvento, Model model ) {
		Eventos even = evendao.buscarPorId(idEvento);
		
		if(even != null) {
			model.addAttribute("evento", even);
			return "detalles";
		}else
			model.addAttribute("mensaje", "Evento no Existe");
			return "forward:/";
		
	}
	
	@GetMapping("/eliminar/{id}")
		public String mostrarEliminar(@PathVariable("id") int idEvento, Model model) {
			if(evendao.borrar(idEvento)== 1)
				model.addAttribute("mensaje", "El Evento ha sido Eliminado");
			else
				model.addAttribute("mensaje", "El Evento no se puede Eliminar");
			
			return "forward:/";
		}
	
	@GetMapping("/alta")
	public String mostarAlta() {
		return "alta";
	}
	
	@PostMapping("/alta")
	public String procAlta(Eventos evento, RedirectAttributes ratt) {
		if(evendao.alta(evento) == 1)
			ratt.addFlashAttribute("mensaje", "El Evento se ha dado de Alta");
		else
			ratt.addFlashAttribute("mensaje", "El Evento no se ha dado de Alta");
		
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostarEditar(@PathVariable("id") int idEvento, Model model) {
		Eventos even = evendao.buscarPorId(idEvento);
		
		if(even != null) {
			model.addAttribute("evento", even);
			return "editar";
		}else
			model.addAttribute("mensaje", "El evento no Existe");
		return "forward:/";	
		
	}
	
	@PostMapping("/editar/{id}")
	public String modificarEditar(Eventos evento, @PathVariable("id") int idEvento, RedirectAttributes ratt) {
		evento.setIdEvento(idEvento);
		
		if(evendao.modificar(evento) == 1) {
			ratt.addFlashAttribute("mensaje", "Se ha modificado el Cliente");
		}else
			ratt.addFlashAttribute("mensaje", "No se ha modificado el Cliente");
		
		return "redirect:/";
	}
	
	
	@GetMapping("/cancelar/{id}")
	public String cancelarEvento(Eventos even, @PathVariable("id") int idEvento, Model model) {
		even = evendao.buscarPorId(idEvento);
		if(even.getIdEvento() == idEvento) {
			even.setEstado("Cancelado");
			model.addAttribute("mensaje", "El Evento ha sido Cancelado");
		}
		else
			model.addAttribute("mensaje", "El Evento no ha sido Cancelado");
		
		return "forward:/";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
