package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.InvoiceType;
import com.transion.backend.repository.InvoiceTypeRepository;
import com.transion.backend.service.InvoiceTypeService;

@Service
public class InvoiceTypeServiceImpl implements InvoiceTypeService{

	@Autowired
	InvoiceTypeRepository itRepository;
	
	@Override
	public InvoiceType save(InvoiceType invoiceType) {
		return itRepository.save(invoiceType);
	}

	@Override
	public List<InvoiceType> save(List<InvoiceType> invoiceTypes) {
		return (List<InvoiceType>) itRepository.save(invoiceTypes);
	}

	@Override
	public InvoiceType findOne(Long id) {
		return itRepository.findOne(id);
	}

	@Override
	public List<InvoiceType> findAll() {
		return (List<InvoiceType>) itRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		itRepository.delete(id);
	}

	@Override
	public void delete(InvoiceType invoiceType) {
		itRepository.delete(invoiceType);
	}

	@Override
	public void deleteAll() {
		itRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<InvoiceType> invoiceTypes) {
		itRepository.delete(invoiceTypes);
	}

}
