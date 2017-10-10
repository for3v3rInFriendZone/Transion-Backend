package com.transion.backend.service.importexport;

import java.util.List;

import com.transion.backend.model.importexport.Import;

public interface ImportService {

	public Import save(Import import1);
	
	public List<Import> save(List<Import> imports);
	
	public Import findOne(Long id);
	
	public List<Import> findAll();
	
	public void delete(Long id);
	
	public void delete(Import import1);
	
	public void deleteAll();
	
	public void deleteAll(List<Import> imports);
}
