package com.ismo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ismo.connection.SingletonConnection;
import com.ismo.model.Produit;

public class DAOProduit implements IDao<Produit> {

	@Override
	public List<Produit> getAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection c = SingletonConnection.getInstance();
		Statement st = c.createStatement();
		ResultSet rst = st.executeQuery("SELECT * FROM PRODUIT"); 
		
		ArrayList<Produit> prds = new ArrayList<Produit>();
		
		while(rst.next()) {
			Produit p = new Produit();
			p.setId(rst.getInt(1));
			p.setNom(rst.getString(2));
			p.setFamille(rst.getString(3));
			p.setPrix_achat(rst.getDouble(4));
			p.setPrix_vente(rst.getDouble(5));
			prds.add(p);
		}
		return prds;
	}

	@Override
	public Produit getOne(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection c = SingletonConnection.getInstance();
		PreparedStatement st = c.prepareStatement("SELECT * FROM PRODUIT WHERE ID = ?");
		st.setInt(1, id);
		
		ResultSet rst = st.executeQuery();
		
		Produit p = null;
		
		if(rst.next()) {
			p = new Produit();
			p.setId(rst.getInt(1));
			p.setNom(rst.getString(2));
			p.setFamille(rst.getString(3));
			p.setPrix_achat(rst.getDouble(4));
			p.setPrix_vente(rst.getDouble(5));
		}
		return p;
	}

	@Override
	public boolean add(Produit p) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection c = SingletonConnection.getInstance();
		PreparedStatement st = c.prepareStatement("INSERT INTO PRODUIT VALUES (null,?,?,?,?)");
		st.setString(1, p.getNom());
		st.setString(2, p.getFamille());
		st.setDouble(3, p.getPrix_achat());
		st.setDouble(4, p.getPrix_vente());
		
		int nb = st.executeUpdate();
		
		return nb==0 ? false: true;
	}

	@Override
	public boolean update(Produit p) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection c = SingletonConnection.getInstance();
		PreparedStatement st = c.prepareStatement("UPDATE PRODUIT SET nom = ?, famille= ?, prix_achat = ?, prix_vente = ? where id=?");
		st.setString(1, p.getNom());
		st.setString(2, p.getFamille());
		st.setDouble(3, p.getPrix_achat());
		st.setDouble(4, p.getPrix_vente());
		st.setInt(5, p.getId());
		
		int nb = st.executeUpdate();
		
		return nb==0 ? false: true;
	}

	@Override
	public boolean delete(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection c = SingletonConnection.getInstance();
		PreparedStatement st = c.prepareStatement("DELETE FROM PRODUIT where id=?");
		st.setInt(1, id);
		
		int nb = st.executeUpdate();
		
		return nb==0 ? false: true;
	}

}
