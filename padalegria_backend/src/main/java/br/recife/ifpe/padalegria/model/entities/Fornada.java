package br.recife.ifpe.padalegria.model.entities;

import java.sql.Time;

public class Fornada {
	private int id;
	private Time tempoPreparo;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Time getTempoPreparo() {
		return tempoPreparo;
	}
	public void setTempoPreparo(Time tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
