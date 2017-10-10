package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long>{

}
