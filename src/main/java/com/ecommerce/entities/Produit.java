package com.ecommerce.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Double prix;
    
    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id")
    @JsonIgnoreProperties("Categorie-Produit")
    private Categorie categorie;
    
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("Produit-ProduitPanier")
	private List<ProduitPanier> produitPanier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<ProduitPanier> getProduitPanier() {
		return produitPanier;
	}

	public void setProduitPanier(List<ProduitPanier> produitPanier) {
		this.produitPanier = produitPanier;
	}

	public Produit(Long id, String nom, String description, Double prix, Categorie categorie,
			List<ProduitPanier> produitPanier) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.categorie = categorie;
		this.produitPanier = produitPanier;
	}

	public Produit() {
		super();
	}
    
    
 // Getters et Setters
    

    

}
