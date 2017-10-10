package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.CustomForm;
import com.transion.backend.repository.CustomFormRepository;
import com.transion.backend.service.CustomFormService;

@Service
public class CustomFormServiceImpl implements CustomFormService{

	@Autowired
	CustomFormRepository cfRepository;
	
	@Override
	public CustomForm save(CustomForm customForm) {
		return cfRepository.save(customForm);
	}

	@Override
	public List<CustomForm> save(List<CustomForm> customForms) {
		return (List<CustomForm>) cfRepository.save(customForms);
	}

	@Override
	public CustomForm findOne(Long id) {
		return cfRepository.findOne(id);
	}

	@Override
	public List<CustomForm> findAll() {
		return (List<CustomForm>) cfRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		cfRepository.delete(id);
	}

	@Override
	public void delete(CustomForm customForm) {
		cfRepository.delete(customForm);
	}

	@Override
	public void deleteAll() {
		cfRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<CustomForm> customForms) {
		cfRepository.delete(customForms);
	}

}
