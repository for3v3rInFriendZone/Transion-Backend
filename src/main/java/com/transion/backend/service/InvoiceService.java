package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Invoice;

public interface InvoiceService {

	public Invoice save(Invoice invoice);
	
	public List<Invoice> save(List<Invoice> invoices);
	
	public Invoice findOne(Long id);
	
	public List<Invoice> findAll();
	
	public void delete(Long id);
	
	public void delete(Invoice invoice);
	
	public void deleteAll();
	
	public void deleteAll(List<Invoice> invoices);
}
