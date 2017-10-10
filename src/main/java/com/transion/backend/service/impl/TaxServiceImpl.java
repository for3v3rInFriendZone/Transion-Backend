package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Tax;
import com.transion.backend.repository.TaxRepository;
import com.transion.backend.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService{

	@Autowired
	TaxRepository taxRepository;
	
	@Override
	public Tax save(Tax tax) {
		return taxRepository.save(tax);
	}

	@Override
	public List<Tax> save(List<Tax> taxs) {
		return (List<Tax>) taxRepository.save(taxs);
	}

	@Override
	public Tax findOne(Long id) {
		return taxRepository.findOne(id);
	}

	@Override
	public List<Tax> findAll() {
		return (List<Tax>) taxRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		taxRepository.delete(id);
	}

	@Override
	public void delete(Tax tax) {
		taxRepository.delete(tax);
	}

	@Override
	public void deleteAll() {
		taxRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Tax> taxs) {
		taxRepository.delete(taxs);
	}

}
