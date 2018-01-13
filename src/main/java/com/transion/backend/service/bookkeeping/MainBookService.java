package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.MainBook;

public interface MainBookService {

	public MainBook save(MainBook mainBook);
	
	public List<MainBook> save(List<MainBook> mainBooks);
	
	public MainBook findOne(Long id);
	
	public List<MainBook> findAll();
	
	public void delete(Long id);
	
	public void delete(MainBook mainBook);
	
	public void deleteAll();
	
	public void deleteAll(List<MainBook> mainBooks);
}
