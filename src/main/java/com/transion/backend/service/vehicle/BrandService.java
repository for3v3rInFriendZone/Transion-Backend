package com.transion.backend.service.vehicle;

import java.util.List;

import com.transion.backend.model.vehicle.Brand;

public interface BrandService {

	public Brand save(Brand brand);
	
	public List<Brand> save(List<Brand> brands);
	
	public Brand findOne(Long id);
	
	public List<Brand> findAll();
	
	public void delete(Long id);
	
	public void delete(Brand brand);
	
	public void deleteAll();
	
	public void deleteAll(List<Brand> brands);
}
