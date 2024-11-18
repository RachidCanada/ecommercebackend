package com.ecommerce.requests;

import com.ecommerce.entities.Produit;

public class RequestAddProduit {
	private Produit produit;
	private Long id_categorie;
	
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Long getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(Long id_categorie) {
		this.id_categorie = id_categorie;
	}
	
	
}
