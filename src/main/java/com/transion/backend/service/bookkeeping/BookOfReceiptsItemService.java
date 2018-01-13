package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.BookOfReceiptsItem;

public interface BookOfReceiptsItemService {
	
	public BookOfReceiptsItem save(BookOfReceiptsItem receiptsBookItem);
	
	public List<BookOfReceiptsItem> save(List<BookOfReceiptsItem> receiptsBookItems);
	
	public BookOfReceiptsItem findOne(Long id);
	
	public List<BookOfReceiptsItem> findAll();
	
	public void delete(Long id);
	
	public void delete(BookOfReceiptsItem receiptsBookItem);
	
	public void deleteAll();
	
	public void deleteAll(List<BookOfReceiptsItem> receiptsBookItems);
}
