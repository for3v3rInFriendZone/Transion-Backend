package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends CrudRepository<InvoiceItem, Long>{

}
