package com.transion.backend.service.address;

import java.util.List;

import com.transion.backend.model.address.Country;

public interface CountryService {

	public Country save(Country country);
	
	public List<Country> save(List<Country> countries);
	
	public Country findOne(Long id);
	
	public List<Country> findAll();
	
	public void delete(Long id);
	
	public void delete(Country country);
	
	public void deleteAll();
	
	public void deleteAll(List<Country> countries);
}
