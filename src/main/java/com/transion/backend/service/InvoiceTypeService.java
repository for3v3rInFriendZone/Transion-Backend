package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.InvoiceType;

public interface InvoiceTypeService {

	public InvoiceType save(InvoiceType invoiceType);
	
	public List<InvoiceType> save(List<InvoiceType> invoiceTypes);
	
	public InvoiceType findOne(Long id);
	
	public List<InvoiceType> findAll();
	
	public void delete(Long id);
	
	public void delete(InvoiceType invoiceType);
	
	public void deleteAll();
	
	public void deleteAll(List<InvoiceType> invoiceTypes);
}
