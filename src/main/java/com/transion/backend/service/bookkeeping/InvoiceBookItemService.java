package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.InvoiceBookItem;

public interface InvoiceBookItemService {
	
	public InvoiceBookItem save(InvoiceBookItem item);
	
	public List<InvoiceBookItem> save(List<InvoiceBookItem> items);
	
	public InvoiceBookItem findOne(Long id);
	
	public List<InvoiceBookItem> findAll();
	
	public void delete(Long id);
	
	public void delete(InvoiceBookItem item);
	
	public void deleteAll();
	
	public void deleteAll(List<InvoiceBookItem> items);
}
