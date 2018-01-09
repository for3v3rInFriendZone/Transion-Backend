package com.transion.backend.repository.bookkeeping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.bookkeeping.InvoiceBookItem;

@Repository
public interface InvoiceBookItemRepository extends CrudRepository<InvoiceBookItem, Long>{

}
