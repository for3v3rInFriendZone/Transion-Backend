package com.transion.backend.service.address.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.address.City;
import com.transion.backend.repository.address.CityRepository;
import com.transion.backend.service.address.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public List<City> save(List<City> cities) {
		return (List<City>) cityRepository.save(cities);
	}

	@Override
	public City findOne(Long id) {
		return cityRepository.findOne(id);
	}

	@Override
	public List<City> findAll() {
		return (List<City>) cityRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		cityRepository.delete(id);
	}

	@Override
	public void delete(City city) {
		cityRepository.delete(city);
	}

	@Override
	public void deleteAll() {
		cityRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<City> cities) {
		cityRepository.delete(cities);
	}

}
