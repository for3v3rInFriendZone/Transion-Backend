package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.CustomFormConfig;
import com.transion.backend.repository.CustomFormConfigRepository;
import com.transion.backend.service.CustomFormConfigService;

@Service
public class CustomFormConfigServiceImpl implements CustomFormConfigService{

	@Autowired
	CustomFormConfigRepository cfcRepository;
	
	@Override
	public CustomFormConfig save(CustomFormConfig customFormConfig) {
		return cfcRepository.save(customFormConfig);
	}

	@Override
	public List<CustomFormConfig> save(List<CustomFormConfig> customFormCongigs) {
		return (List<CustomFormConfig>) cfcRepository.save(customFormCongigs);
	}

	@Override
	public CustomFormConfig findOne(Long id) {
		return cfcRepository.findOne(id);
	}

	@Override
	public List<CustomFormConfig> findAll() {
		return (List<CustomFormConfig>) cfcRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		cfcRepository.delete(id);
	}

	@Override
	public void delete(CustomFormConfig customFormConfig) {
		cfcRepository.delete(customFormConfig);
	}

	@Override
	public void deleteAll() {
		cfcRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<CustomFormConfig> customFormConfigs) {
		cfcRepository.delete(customFormConfigs);
	}

}
