package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
