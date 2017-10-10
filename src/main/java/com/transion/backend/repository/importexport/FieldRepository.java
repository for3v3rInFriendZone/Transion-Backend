package com.transion.backend.repository.importexport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.importexport.Field;

@Repository
public interface FieldRepository extends CrudRepository<Field, Long>{

}
