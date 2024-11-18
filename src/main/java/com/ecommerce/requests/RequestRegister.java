package com.ecommerce.requests;

import com.ecommerce.entities.Client;
import com.ecommerce.entities.Compte;

public class RequestRegister {
	private Compte compte;
	private Client client;
	
	
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
