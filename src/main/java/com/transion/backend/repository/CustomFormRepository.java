package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.CustomForm;

@Repository
public interface CustomFormRepository extends CrudRepository<CustomForm, Long>{

}
