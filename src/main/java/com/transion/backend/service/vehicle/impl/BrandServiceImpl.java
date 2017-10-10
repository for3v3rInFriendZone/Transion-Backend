package com.transion.backend.service.vehicle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.vehicle.Brand;
import com.transion.backend.repository.vehicle.BrandRepository;
import com.transion.backend.service.vehicle.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;
	
	@Override
	public Brand save(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> save(List<Brand> brands) {
		return (List<Brand>) brandRepository.save(brands);
	}

	@Override
	public Brand findOne(Long id) {
		return brandRepository.findOne(id);
	}

	@Override
	public List<Brand> findAll() {
		return (List<Brand>) brandRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		brandRepository.delete(id);
	}

	@Override
	public void delete(Brand brand) {
		brandRepository.delete(brand);
	}

	@Override
	public void deleteAll() {
		brandRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Brand> brands) {
		brandRepository.delete(brands);
	}

}
