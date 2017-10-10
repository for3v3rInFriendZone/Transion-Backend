package com.transion.backend.service.importexport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.importexport.Field;
import com.transion.backend.repository.importexport.FieldRepository;
import com.transion.backend.service.importexport.FieldService;

@Service
public class FieldServiceImpl implements FieldService{

	@Autowired
	FieldRepository fieldRepository;
	
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

}
