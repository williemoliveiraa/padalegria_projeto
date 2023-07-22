package br.recife.ifpe.padalegria.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.recife.ifpe.padalegria.model.entities.Fornada;
import br.recife.ifpe.padalegria.model.repositories.RepositoryFacade;

@Controller
@RequestMapping("/fornada")
public class FornadaController {
	@GetMapping("/create")
	public String telaCadastro(Model m) {
		return "cadastroFornada"; //FAZER JSP DE CADASTRO DA FORNADA
	}
	
	@PostMapping("/create")
	public String create(Model m, Fornada fornada, HttpServletRequest request) {
		
		RepositoryFacade.getCurrentInstance().create(fornada);
		m.addAttribute("msg", "Fornada cadastrada com sucesso");
		
		return list(m);
	}
	
	@GetMapping( path = {"", "/"})
	public String list(Model m) {
		
		List<Fornada> fornadas = RepositoryFacade.getCurrentInstance().readAllFornadas();
		
		m.addAttribute("fornadas", fornadas);
		
		return "listFornadas"; //FAZER JSP QUE EXIBE LISTA DE FORNADAS
	
	}
	
	
	@GetMapping("/{id}")
	public String detail(Model m,@PathVariable("id") int id) {
		
		Fornada fornada = RepositoryFacade.getCurrentInstance().readFornada(id);
		
		m.addAttribute("fornada", fornada);
		
		return "detailfornada"; 
	}
	
	// Não implementamos atualizar ou deletar
	
	
}
