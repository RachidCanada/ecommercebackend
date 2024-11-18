package com.ecommerce.entities;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Panier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @JsonIgnoreProperties("Client-Panier")
    private Client client;
    
    @OneToOne(mappedBy = "panier", cascade = CascadeType.ALL)
    private Commande commande;
    
    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("Panier-ProduitPanier")
	private List<ProduitPanier> produitPanier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<ProduitPanier> getProduitPanier() {
		return produitPanier;
	}

	public void setProduitPanier(List<ProduitPanier> produitCommandes) {
		this.produitPanier = produitCommandes;
	}

	public Panier(Long id, Client client, Commande commande, List<ProduitPanier> produitPanier) {
		super();
		this.id = id;
		this.client = client;
		this.commande = commande;
		this.produitPanier = produitPanier;
	}

	public Panier() {
		super();
	}
    
    

}
