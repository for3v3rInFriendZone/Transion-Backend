package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.ResponsibleUser;

@Repository
public interface ResponsibleUserRepository extends CrudRepository<ResponsibleUser, Long>{

}
