package com.transion.backend.service.importexport;

import java.util.List;
import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.model.importexport.Mapping.MappingType;

public interface FieldService {

	public Field save(Field field);
	
	public List<Field> save(List<Field> fields);
	
	public Field findOne(Long id);
	
	public List<Field> findAll();
	
	public void delete(Long id);
	
	public void delete(Field field);
	
	public void deleteAll();
	
	public void deleteAll(List<Field> fields);

	public List<Field> getListOfFields(MappingType type);
	
	public void updateMappingId(Long mappingId, Long fieldId);
	
	public List<Field> findByMapping(Mapping mapping);
}
