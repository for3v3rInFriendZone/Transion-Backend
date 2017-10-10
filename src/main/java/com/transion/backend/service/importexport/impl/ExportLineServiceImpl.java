package com.transion.backend.service.importexport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.importexport.ExportLine;
import com.transion.backend.repository.importexport.ExportLineRepository;
import com.transion.backend.service.importexport.ExportLineService;

@Service
public class ExportLineServiceImpl implements ExportLineService{

	@Autowired
	ExportLineRepository elRepository;
	
	@Override
	public ExportLine save(ExportLine exportLine) {
		return elRepository.save(exportLine);
	}

	@Override
	public List<ExportLine> save(List<ExportLine> exportLines) {
		return (List<ExportLine>) elRepository.save(exportLines);
	}

	@Override
	public ExportLine findOne(Long id) {
		return elRepository.findOne(id);
	}

	@Override
	public List<ExportLine> findAll() {
		return (List<ExportLine>) elRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		elRepository.delete(id);
	}

	@Override
	public void delete(ExportLine exportLine) {
		elRepository.delete(exportLine);
	}

	@Override
	public void deleteAll() {
		elRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<ExportLine> exportLines) {
		elRepository.delete(exportLines);
	}

}
