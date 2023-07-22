package br.recife.ifpe.padalegria.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.recife.ifpe.padalegria.model.entities.Pao;
import br.recife.ifpe.padalegria.model.repositories.RepositoryFacade;

@Controller
@RequestMapping("/pao")
public class PaoController {

	@GetMapping("/create")
	public String telaCadastro(Model m) {
		return "cadastroPao"; //FAZER JSP DE CADASTRO DE POES
	}

	@PostMapping("/create")
	public String create(Model m, Pao pao, HttpServletRequest request) {

		RepositoryFacade.getCurrentInstance().create(pao);
		m.addAttribute("msg", "Pao novo cadastrado com sucesso");

		return list(m);
	}

	@GetMapping(path = { "", "/" })
	public String list(Model m) {

		List<Pao> paes = RepositoryFacade.getCurrentInstance().readAllPaes();

		m.addAttribute("paes", paes);

		return "listPaes"; //FAZER JSP QUE EXIBE LISTA DE POES

	}

	@GetMapping("/{id}")
	public String detail(Model m, @PathVariable("id") int id) {

		Pao pao = RepositoryFacade.getCurrentInstance().readPao(id);

		m.addAttribute("pao", pao);

		return "detailPao"; //FAZER JSP QUE DETALHE SOBRE UM POE
	}
}
