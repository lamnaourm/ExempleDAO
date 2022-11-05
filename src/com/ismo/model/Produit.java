package com.ismo.model;

public class Produit {

	private int id;
	private String nom;
	private String famille;
	private double prix_achat;
	private double prix_vente;

	public Produit() {

	}

	public Produit(int id, String nom, String famille, double prix_achat, double prix_vente) {
		super();
		this.id = id;
		this.nom = nom;
		this.famille = famille;
		this.prix_achat = prix_achat;
		this.prix_vente = prix_vente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public double getPrix_achat() {
		return prix_achat;
	}

	public void setPrix_achat(double prix_achat) {
		this.prix_achat = prix_achat;
	}

	public double getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(double prix_vente) {
		this.prix_vente = prix_vente;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", famille=" + famille + ", prix_achat=" + prix_achat
				+ ", prix_vente=" + prix_vente + "]";
	}

}
