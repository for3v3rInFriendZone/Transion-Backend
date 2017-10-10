package com.transion.backend.service.importexport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.importexport.Import;
import com.transion.backend.repository.importexport.ImportRepository;
import com.transion.backend.service.importexport.ImportService;

@Service
public class ImportServiceImpl implements ImportService{

	@Autowired
	ImportRepository importRepository;
	
	@Override
	public Import save(Import import1) {
		return importRepository.save(import1);
	}

	@Override
	public List<Import> save(List<Import> imports) {
		return (List<Import>) importRepository.save(imports);
	}

	@Override
	public Import findOne(Long id) {
		return importRepository.findOne(id);
	}

	@Override
	public List<Import> findAll() {
		return (List<Import>) importRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		importRepository.delete(id);
	}

	@Override
	public void delete(Import import1) {
		importRepository.delete(import1);
	}

	@Override
	public void deleteAll() {
		importRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Import> imports) {
		importRepository.delete(imports);
	}

}
