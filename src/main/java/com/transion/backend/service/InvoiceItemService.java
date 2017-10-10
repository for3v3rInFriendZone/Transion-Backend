package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.InvoiceItem;

public interface InvoiceItemService {

	public InvoiceItem save(InvoiceItem invoiceItem);
	
	public List<InvoiceItem> save(List<InvoiceItem> invoiceItems);
	
	public InvoiceItem findOne(Long id);
	
	public List<InvoiceItem> findAll();
	
	public void delete(Long id);
	
	public void delete(InvoiceItem invoiceItem);
	
	public void deleteAll();
	
	public void deleteAll(List<InvoiceItem> invoiceItems);
}
