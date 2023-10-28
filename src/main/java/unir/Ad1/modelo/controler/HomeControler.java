package unir.Ad1.modelo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import unir.Ad1.modelo.dao.EventosDao;



@Controller
public class HomeControler {
	
	@Autowired
	private EventosDao dao;
	
	@GetMapping("/")
	public String mostrarActivos(Model model) {
			model.addAttribute("eventos", dao.buscarPorActivo());
			return "index";		
	}
	
}

