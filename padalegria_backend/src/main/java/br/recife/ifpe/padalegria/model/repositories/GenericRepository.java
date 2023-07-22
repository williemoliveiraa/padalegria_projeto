package br.recife.ifpe.padalegria.model.repositories;

import java.util.List;

public interface GenericRepository <T, I>{
	
	public void create(T t);
	public void update(T t);
	public List<T> readAll();
	public T read(I key);

}
