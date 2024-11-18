package com.ecommerce.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numero_carte;
    
    private Date date_exp;
    
    private int cc;
    
    @OneToOne
    @JoinColumn(name = "id_panier", referencedColumnName = "id")
	private Panier panier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero_carte() {
		return numero_carte;
	}

	public void setNumero_carte(String numero_carte) {
		this.numero_carte = numero_carte;
	}

	public Date getDate_exp() {
		return date_exp;
	}

	public void setDate_exp(Date date_exp) {
		this.date_exp = date_exp;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	

	public Commande(Long id, String numero_carte, Date date_exp, int cc, Panier panier) {
		super();
		this.id = id;
		this.numero_carte = numero_carte;
		this.date_exp = date_exp;
		this.cc = cc;
		this.panier = panier;
	}

	public Commande() {
		super();
	}
    
    
    

}
