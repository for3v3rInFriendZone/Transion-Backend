package com.transion.backend.service.importexport;

import java.util.List;

import com.transion.backend.model.importexport.Export;

public interface ExportService {

	public Export save(Export export);
	
	public List<Export> save(List<Export> exports);
	
	public Export findOne(Long id);
	
	public List<Export> findAll();
	
	public void delete(Long id);
	
	public void delete(Export export);
	
	public void deleteAll();
	
	public void deleteAll(List<Export> exports);
}
