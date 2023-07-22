package br.recife.ifpe.padalegria.model.entities;

public class Padeiro {
	
	private int id;
	private String nome;
	
	private Fornada fornada;
	private Pao pao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Fornada getFornada() {
		return fornada;
	}
	public void setFornada(Fornada fornada) {
		this.fornada = fornada;
	}
	
	public Pao getPao() {
		return pao;
	}
	public void setPao(Pao pao) {
		this.pao = pao;
	}
	
}
