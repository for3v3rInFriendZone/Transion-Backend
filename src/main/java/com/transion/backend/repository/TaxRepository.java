package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Tax;

@Repository
public interface TaxRepository extends CrudRepository<Tax, Long>{

}
