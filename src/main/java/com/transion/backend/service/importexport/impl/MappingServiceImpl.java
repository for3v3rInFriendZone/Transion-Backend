package com.transion.backend.service.importexport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.repository.importexport.MappingRepository;
import com.transion.backend.service.importexport.MappingService;

@Service
public class MappingServiceImpl implements MappingService{

	@Autowired
	MappingRepository mappingRepository;
	
	@Override
	public Mapping save(Mapping mapping) {
		return mappingRepository.save(mapping);
	}

	@Override
	public List<Mapping> save(List<Mapping> mappings) {
		return (List<Mapping>) mappingRepository.save(mappings);
	}

	@Override
	public Mapping findOne(Long id) {
		return mappingRepository.findOne(id);
	}

	@Override
	public List<Mapping> findAll() {
		return (List<Mapping>) mappingRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		mappingRepository.delete(id);
	}

	@Override
	public void delete(Mapping mapping) {
		mappingRepository.delete(mapping);
	}

	@Override
	public void deleteAll() {
		mappingRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Mapping> mappings) {
		mappingRepository.delete(mappings);
	}

}
