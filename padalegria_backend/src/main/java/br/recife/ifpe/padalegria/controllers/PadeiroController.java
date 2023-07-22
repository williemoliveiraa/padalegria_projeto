package br.recife.ifpe.padalegria.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.recife.ifpe.padalegria.model.entities.Padeiro;
import br.recife.ifpe.padalegria.model.repositories.RepositoryFacade;

@Controller
@RequestMapping("/padeiro")
public class PadeiroController {
	@GetMapping("/create")
	public String telaCadastro(Model m) {
		return "cadastroPadeiro"; //FAZER JSP DE CADASTRO DO PADEIRO
	}
	
	@PostMapping("/create")
	public String create(Model m, Padeiro padeiro, HttpServletRequest request) {
		
		RepositoryFacade.getCurrentInstance().create(padeiro);
		m.addAttribute("msg", "Padeiro cadastrado com sucesso");
		
		return list(m);
	}
	
	@GetMapping( path = {"", "/"})
	public String list(Model m) {
		
		List<Padeiro> padeiros = RepositoryFacade.getCurrentInstance().readAllPadeiros();
		
		m.addAttribute("padeiros", padeiros);
		
		return "listPadeiros"; //FAZER JSP QUE EXIBE LISTA DE PADEIROS
	
	}
	
	
	@GetMapping("/{id}")
	public String detail(Model m,@PathVariable("id") int id) {
		
		Padeiro padeiro = RepositoryFacade.getCurrentInstance().readPadeiro(id);
		
		m.addAttribute("padeiro", padeiro);
		
		return "detailPadeiro";  //FAZER JSP QUE DETALHE SOBRE UM PADEIRO
	}
	
	// Não implementamos atualizar ou deletar
	
	
}
