package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.CustomFormConfig;

@Repository
public interface CustomFormConfigRepository extends CrudRepository<CustomFormConfig, Long>{

}
