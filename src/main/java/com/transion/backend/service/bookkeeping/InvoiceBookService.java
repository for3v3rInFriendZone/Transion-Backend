package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.InvoiceBook;

public interface InvoiceBookService {

	public InvoiceBook save(InvoiceBook invoiceBook);
	
	public List<InvoiceBook> save(List<InvoiceBook> invoiceBooks);
	
	public InvoiceBook findOne(Long id);
	
	public List<InvoiceBook> findAll();
	
	public void delete(Long id);
	
	public void delete(InvoiceBook invoiceBook);
	
	public void deleteAll();
	
	public void deleteAll(List<InvoiceBook> invoiceBooks);
}
