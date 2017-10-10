package com.transion.backend.service.address;

import java.util.List;

import com.transion.backend.model.address.City;

public interface CityService {

	public City save(City city);
	
	public List<City> save(List<City> cities);
	
	public City findOne(Long id);
	
	public List<City> findAll();
	
	public void delete(Long id);
	
	public void delete(City city);
	
	public void deleteAll();
	
	public void deleteAll(List<City> cities);
}
