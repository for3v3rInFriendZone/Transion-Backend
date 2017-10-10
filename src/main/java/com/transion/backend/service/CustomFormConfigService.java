package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.CustomFormConfig;

public interface CustomFormConfigService {

	public CustomFormConfig save(CustomFormConfig customFormConfig);
	
	public List<CustomFormConfig> save(List<CustomFormConfig> customFormCongigs);
	
	public CustomFormConfig findOne(Long id);
	
	public List<CustomFormConfig> findAll();
	
	public void delete(Long id);
	
	public void delete(CustomFormConfig customFormConfig);
	
	public void deleteAll();
	
	public void deleteAll(List<CustomFormConfig> customFormConfigs);
}
