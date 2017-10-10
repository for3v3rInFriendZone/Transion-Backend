package com.transion.backend.service.importexport;

import java.util.List;

import com.transion.backend.model.importexport.ExportLine;

public interface ExportLineService {

	public ExportLine save(ExportLine exportLine);
	
	public List<ExportLine> save(List<ExportLine> exportLines);
	
	public ExportLine findOne(Long id);
	
	public List<ExportLine> findAll();
	
	public void delete(Long id);
	
	public void delete(ExportLine exportLine);
	
	public void deleteAll();
	
	public void deleteAll(List<ExportLine> exportLines);
}
