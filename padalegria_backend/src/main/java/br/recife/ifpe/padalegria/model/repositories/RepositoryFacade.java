package br.recife.ifpe.padalegria.model.repositories;

import java.util.List;

import br.recife.ifpe.padalegria.model.entities.Padeiro;
import br.recife.ifpe.padalegria.model.entities.Pao;
import br.recife.ifpe.padalegria.model.entities.Fornada;

public class RepositoryFacade {
	
	private static RepositoryFacade myself = new RepositoryFacade();
			
	private GenericRepository<Padeiro, Integer> padeiroRep = null;
	private GenericRepository<Pao, Integer> paoRep = null;
	private GenericRepository<Fornada, Integer> fornadaRep = null;
	
	private RepositoryFacade() {
		
		this.padeiroRep = new PadeiroRepository();
		this.paoRep = new PaoRepository();
		this.fornadaRep = new FornadaRepository();
		
	}
	
	public static RepositoryFacade getCurrentInstance() {
		return myself;
	}
	
	public void create(Padeiro padeiro) {
		this.padeiroRep.create(padeiro);
	}
	
	public void create(Pao pao) {
		this.paoRep.create(pao);
	}
	
	public void create(Fornada fornada) {
		this.fornadaRep.create(fornada);
	}
	
	
	
	public Padeiro readPadeiro(int id) {
		return this.padeiroRep.read(id);
	}
	
	public Pao readPao(int id) {
		return this.paoRep.read(id);
	}
	
	public Fornada readFornada(int id) {
		return this.fornadaRep.read(id);
	}
	
	
	
	public List<Padeiro> readAllPadeiros(){
		return this.padeiroRep.readAll();
	}
	
	public List<Pao> readAllPaes(){
		return this.paoRep.readAll();
	}
	
	public List<Fornada> readAllFornadas(){
		return this.fornadaRep.readAll();
	}

}
