package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.BookOfIssuedInvoice;

public interface BookOfIssuedInvoiceService {

	public BookOfIssuedInvoice save(BookOfIssuedInvoice invoiceBook);
	
	public List<BookOfIssuedInvoice> save(List<BookOfIssuedInvoice> invoiceBooks);
	
	public BookOfIssuedInvoice findOne(Long id);
	
	public List<BookOfIssuedInvoice> findAll();
	
	public void delete(Long id);
	
	public void delete(BookOfIssuedInvoice invoiceBook);
	
	public void deleteAll();
	
	public void deleteAll(List<BookOfIssuedInvoice> invoiceBooks);
}
