package com.ismo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ismo.model.Produit;

public interface IDao<T> {

	
	List<T> getAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	T getOne(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	boolean add(T p) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	boolean update(T p) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	boolean delete(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
}
