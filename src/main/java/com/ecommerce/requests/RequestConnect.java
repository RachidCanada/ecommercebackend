package com.ecommerce.requests;

import com.ecommerce.entities.Compte;
import com.ecommerce.entities.Panier;

public class RequestConnect {
	private Compte compte;
	private Panier panier;
	
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	
	
}
