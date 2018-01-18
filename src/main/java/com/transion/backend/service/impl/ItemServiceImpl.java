package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Client;
import com.transion.backend.model.Item;
import com.transion.backend.repository.ItemRepository;
import com.transion.backend.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> save(List<Item> items) {
		return (List<Item>) itemRepository.save(items);
	}

	@Override
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		itemRepository.delete(id);
	}

	@Override
	public void delete(Item item) {
		itemRepository.delete(item);
	}

	@Override
	public void deleteAll() {
		itemRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Item> items) {
		itemRepository.delete(items);
	}

	@Override
	public List<Item> findBySupplier(Client client) {
		// TODO Auto-generated method stub
		return itemRepository.findBySupplier(client);
	}
	
	

}
