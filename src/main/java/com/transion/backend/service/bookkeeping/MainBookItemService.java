package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.MainBookItem;


public interface MainBookItemService {

	public MainBookItem save(MainBookItem mainBookItem);
	
	public List<MainBookItem> save(List<MainBookItem> mainBookItems);
	
	public MainBookItem findOne(Long id);
	
	public List<MainBookItem> findAll();
	
	public void delete(Long id);
	
	public void delete(MainBookItem mainBookItem);
	
	public void deleteAll();
	
	public void deleteAll(List<MainBookItem> mainBookItems);
}
