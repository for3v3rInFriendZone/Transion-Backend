package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.BookOfReceipts;

public interface BookOfReceiptsService {

	public BookOfReceipts save(BookOfReceipts receiptsBook);
	
	public List<BookOfReceipts> save(List<BookOfReceipts> receiptsBooks);
	
	public BookOfReceipts findOne(Long id);
	
	public List<BookOfReceipts> findAll();
	
	public void delete(Long id);
	
	public void delete(BookOfReceipts receiptsBook);
	
	public void deleteAll();
	
	public void deleteAll(List<BookOfReceipts> receiptsBooks);
}
