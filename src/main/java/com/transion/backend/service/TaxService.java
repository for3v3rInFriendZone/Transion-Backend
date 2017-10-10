package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Tax;

public interface TaxService {

	public Tax save(Tax tax);
	
	public List<Tax> save(List<Tax> taxs);
	
	public Tax findOne(Long id);
	
	public List<Tax> findAll();
	
	public void delete(Long id);
	
	public void delete(Tax tax);
	
	public void deleteAll();
	
	public void deleteAll(List<Tax> taxs);
}
