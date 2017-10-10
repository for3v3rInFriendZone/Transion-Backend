package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Delivery;
import com.transion.backend.repository.DeliveryRepository;
import com.transion.backend.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Override
	public Delivery save(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public List<Delivery> save(List<Delivery> deliveries) {
		return (List<Delivery>) deliveryRepository.save(deliveries);
	}

	@Override
	public Delivery findOne(Long id) {
		return deliveryRepository.findOne(id);
	}

	@Override
	public List<Delivery> findAll() {
		return (List<Delivery>) deliveryRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		deliveryRepository.delete(id);
	}

	@Override
	public void delete(Delivery delivery) {
		deliveryRepository.delete(delivery);
	}

	@Override
	public void deleteAll() {
		deliveryRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Delivery> deliveries) {
		deliveryRepository.delete(deliveries);
	}

}
