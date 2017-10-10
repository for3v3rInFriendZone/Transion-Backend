package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.CustomForm;

public interface CustomFormService {

	public CustomForm save(CustomForm customForm);
	
	public List<CustomForm> save(List<CustomForm> customForms);
	
	public CustomForm findOne(Long id);
	
	public List<CustomForm> findAll();
	
	public void delete(Long id);
	
	public void delete(CustomForm customForm);
	
	public void deleteAll();
	
	public void deleteAll(List<CustomForm> customForms);
}
