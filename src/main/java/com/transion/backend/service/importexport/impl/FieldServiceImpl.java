package com.transion.backend.service.importexport.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transion.backend.model.Client;
import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.model.importexport.Mapping.MappingType;
import com.transion.backend.repository.importexport.FieldRepository;
import com.transion.backend.service.importexport.FieldService;

@Service
public class FieldServiceImpl implements FieldService{

	@Autowired
	FieldRepository fieldRepository;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public Field save(Field field) {
		return fieldRepository.save(field);
	}

	@Override
	public List<Field> save(List<Field> fields) {
		return (List<Field>) fieldRepository.save(fields);
	}

	@Override
	public Field findOne(Long id) {
		return fieldRepository.findOne(id);
	}

	@Override
	public List<Field> findAll() {
		return (List<Field>) fieldRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		fieldRepository.delete(id);
	}

	@Override
	public void delete(Field field) {
		fieldRepository.delete(field);
	}

	@Override
	public void deleteAll() {
		fieldRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Field> fields) {
		fieldRepository.delete(fields);
	}

	@Override
	public List<Field> getListOfAvalaibleFields(MappingType type) {
		
		/*
		List<Field> fields = new ArrayList<Field>();
		switch (type) {
			case CLIENT:
				fields = Client.clientFields();
				break;
			default:
				fields = null;
				break;
		} */
		List<Field> fields = new ArrayList<Field>();
		fields = em.createNativeQuery("SELECT * FROM FIELD WHERE MAPPING_ID IS NULL AND IMPORT_ENUM LIKE ?1",
				Field.class).setParameter(1, type.toString() + "%").getResultList();
		
		return fields;
	}

	@Override
	public void updateMappingId(Long mappingId, Long fieldId) {
		fieldRepository.updateMapping(mappingId, fieldId);
	}

	@Override
	public List<Field> findByMapping(Mapping mapping) {
		return fieldRepository.findByMapping(mapping);
	}

	@Override
	public List<Field> findByRequired(Boolean required, String type) {
		// TODO Auto-generated method stub
		List<Field> fields = new ArrayList<Field>();
		fields = em.createNativeQuery("SELECT * FROM FIELD WHERE IS_REQUIRED = ?1 AND IMPORT_ENUM LIKE ?2",
				Field.class).setParameter(1, required).setParameter(2, type.toString() + "%").getResultList();
		
		return fields;
		//return fieldRepository.findByRequired(required);
	}

	@Override
	public List<Field> getListOfUsedFields(MappingType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
