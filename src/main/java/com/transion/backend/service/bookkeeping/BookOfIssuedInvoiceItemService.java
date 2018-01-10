package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.BookOfIssuedInvoiceItem;

public interface BookOfIssuedInvoiceItemService {
	
	public BookOfIssuedInvoiceItem save(BookOfIssuedInvoiceItem item);
	
	public List<BookOfIssuedInvoiceItem> save(List<BookOfIssuedInvoiceItem> items);
	
	public BookOfIssuedInvoiceItem findOne(Long id);
	
	public List<BookOfIssuedInvoiceItem> findAll();
	
	public void delete(Long id);
	
	public void delete(BookOfIssuedInvoiceItem item);
	
	public void deleteAll();
	
	public void deleteAll(List<BookOfIssuedInvoiceItem> items);
}
