package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.Client;

public interface RepositoryClient extends JpaRepository<Client, Long> {

}
