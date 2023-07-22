package br.recife.ifpe.padalegria.model.entities;

import java.sql.Time;

public class Pao {

	private int id;
	private String tipoPao;
	private Time tempoPreparo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoPao() {
		return tipoPao;
	}
	public void setTipoPao(String tipoPao) {
		this.tipoPao = tipoPao;
	}
	
	public Time getTempoPreparo() {
		return tempoPreparo;
	}
	public void setTempoPreparo(Time tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
}
