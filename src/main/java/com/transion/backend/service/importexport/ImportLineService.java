package com.transion.backend.service.importexport;

import java.util.List;

import com.transion.backend.model.importexport.ImportLine;

public interface ImportLineService {

	public ImportLine save(ImportLine importLine);
	
	public List<ImportLine> save(List<ImportLine> importLines);
	
	public ImportLine findOne(Long id);
	
	public List<ImportLine> findAll();
	
	public void delete(Long id);
	
	public void delete(ImportLine importLine);
	
	public void deleteAll();
	
	public void deleteAll(List<ImportLine> importLines);
}
