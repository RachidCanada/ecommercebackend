package com.ecommerce.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nom;

	private String prenom;

	private String phone;
	
	@Column(columnDefinition = "DATE")
	private Date date_naissance;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Client-Adresse")
    private List<Adresse> adresses;
	
	@OneToOne
	@JoinColumn(name = "id_compte", referencedColumnName = "id")
	private Compte compte;
	
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Client-Panier")
    private List<Panier> paniers;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

	public Client(Long id, String nom, String prenom, String phone, Date date_naissance, List<Adresse> adresses,
			Compte compte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.phone = phone;
		this.date_naissance = date_naissance;
		this.adresses = adresses;
		this.compte = compte;
	}

	public Client() {
		super();
	}
	
	
}
