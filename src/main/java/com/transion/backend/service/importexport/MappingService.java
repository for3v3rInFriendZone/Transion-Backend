package com.transion.backend.service.importexport;

import java.util.List;

import com.transion.backend.dto.exportimport.MappingDto;
import com.transion.backend.model.importexport.Mapping;

public interface MappingService {

	public Mapping save(MappingDto mappingDto);
	
	public List<Mapping> save(List<Mapping> mappings);
	
	public Mapping findOne(Long id);
	
	public List<Mapping> findAll();
	
	public void delete(Long id);
	
	public void delete(Mapping mapping);
	
	public void deleteAll();
	
	public void deleteAll(List<Mapping> mappings);

}
