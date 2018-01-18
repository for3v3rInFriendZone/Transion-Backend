package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Client;
import com.transion.backend.model.Item;

public interface ItemService {

	public Item save(Item item);
	
	public List<Item> save(List<Item> items);
	
	public Item findOne(Long id);
	
	public List<Item> findAll();
	
	public void delete(Long id);
	
	public void delete(Item item);
	
	public void deleteAll();
	
	public void deleteAll(List<Item> items);
	
	public List<Item> findBySupplier(Client client);
}
