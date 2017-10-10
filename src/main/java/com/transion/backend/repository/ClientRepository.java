package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}
