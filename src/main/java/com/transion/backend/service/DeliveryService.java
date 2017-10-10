package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Delivery;

public interface DeliveryService {

	public Delivery save(Delivery delivery);
	
	public List<Delivery> save(List<Delivery> deliveries);
	
	public Delivery findOne(Long id);
	
	public List<Delivery> findAll();
	
	public void delete(Long id);
	
	public void delete(Delivery delivery);
	
	public void deleteAll();
	
	public void deleteAll(List<Delivery> deliveries);
}
