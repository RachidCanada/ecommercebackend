package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.Commande;

public interface RepositoryCommande extends JpaRepository<Commande, Long>{

}
