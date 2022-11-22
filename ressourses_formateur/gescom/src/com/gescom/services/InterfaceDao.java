package com.gescom.services;

import java.util.List;

public interface InterfaceDao<T> {
	
	public  void insert(T t) throws Exception;
	
	public void update(T t) throws Exception;
	public void delete(T t) throws Exception;
	public  List<T> findAll() throws Exception;
	public T findOneByID(int id) throws Exception;
	
}
