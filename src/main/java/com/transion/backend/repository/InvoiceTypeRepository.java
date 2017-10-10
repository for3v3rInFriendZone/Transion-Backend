package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.InvoiceType;

@Repository
public interface InvoiceTypeRepository extends CrudRepository<InvoiceType, Long>{

}
