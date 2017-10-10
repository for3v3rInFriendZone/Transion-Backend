package com.transion.backend.service.importexport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.importexport.Export;
import com.transion.backend.repository.importexport.ExportRepository;
import com.transion.backend.service.importexport.ExportService;

@Service
public class ExportServiceImpl implements ExportService{

	@Autowired
	ExportRepository exportRepository;
	
	@Override
	public Export save(Export export) {
		return exportRepository.save(export);
	}

	@Override
	public List<Export> save(List<Export> exports) {
		return (List<Export>) exportRepository.save(exports);
	}

	@Override
	public Export findOne(Long id) {
		return exportRepository.findOne(id);
	}

	@Override
	public List<Export> findAll() {
		return (List<Export>) exportRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		exportRepository.delete(id);	
	}

	@Override
	public void delete(Export export) {
		exportRepository.delete(export);
	}

	@Override
	public void deleteAll() {
		exportRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Export> exports) {
		exportRepository.delete(exports);
	}

}
