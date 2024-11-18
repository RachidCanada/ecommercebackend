package com.ecommerce.repositories;


import com.ecommerce.entities.Panier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPanier extends JpaRepository<Panier, Long> {
}
