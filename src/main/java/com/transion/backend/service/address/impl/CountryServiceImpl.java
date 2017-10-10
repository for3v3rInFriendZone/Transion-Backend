package com.transion.backend.service.address.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.address.Country;
import com.transion.backend.repository.address.CountryRepository;
import com.transion.backend.service.address.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public List<Country> save(List<Country> countries) {
		return (List<Country>) countryRepository.save(countries);
	}

	@Override
	public Country findOne(Long id) {
		return countryRepository.findOne(id);
	}

	@Override
	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		countryRepository.delete(id);
	}

	@Override
	public void delete(Country country) {
		countryRepository.delete(country);
	}

	@Override
	public void deleteAll() {
		countryRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Country> countries) {
		countryRepository.delete(countries);
	}

}
