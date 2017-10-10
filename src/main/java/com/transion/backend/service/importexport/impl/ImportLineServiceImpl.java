package com.transion.backend.service.importexport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.importexport.ImportLine;
import com.transion.backend.repository.importexport.ImportLineRepository;
import com.transion.backend.service.importexport.ImportLineService;

@Service
public class ImportLineServiceImpl implements ImportLineService{

	@Autowired
	ImportLineRepository ilRepository;
	
	@Override
	public ImportLine save(ImportLine importLine) {
		return ilRepository.save(importLine);
	}

	@Override
	public List<ImportLine> save(List<ImportLine> importLines) {
		return (List<ImportLine>) ilRepository.save(importLines);
	}

	@Override
	public ImportLine findOne(Long id) {
		return ilRepository.findOne(id);
	}

	@Override
	public List<ImportLine> findAll() {
		return (List<ImportLine>) ilRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		ilRepository.delete(id);
	}

	@Override
	public void delete(ImportLine importLine) {
		ilRepository.delete(importLine);
	}

	@Override
	public void deleteAll() {
		ilRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<ImportLine> importLines) {
		ilRepository.delete(importLines);
	}

}
