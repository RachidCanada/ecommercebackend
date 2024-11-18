package com.ecommerce.entities;

import java.io.Serializable;

import com.ecommerce.utils.TypeCompte;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Compte implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private TypeCompte type = TypeCompte.CLIENT;

	private String email;

	private String password;
	
	@OneToOne(mappedBy = "compte", cascade = CascadeType.ALL)
	private Client client;
	
	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeCompte getType() {
		return type;
	}

	public void setType(TypeCompte type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte(Long id, TypeCompte type, String email, String password, Client client) {
		super();
		this.id = id;
		this.type = type;
		this.email = email;
		this.password = password;
		this.client = client;
	}

	public Compte() {
		super();
	}
	
	
	
}
