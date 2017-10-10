package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.InvoiceItem;
import com.transion.backend.repository.InvoiceItemRepository;
import com.transion.backend.service.InvoiceItemService;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{

	@Autowired
	InvoiceItemRepository iiRepository;
	
	@Override
	public InvoiceItem save(InvoiceItem invoiceItem) {
		return iiRepository.save(invoiceItem);
	}

	@Override
	public List<InvoiceItem> save(List<InvoiceItem> invoiceItems) {
		return (List<InvoiceItem>) iiRepository.save(invoiceItems);
	}

	@Override
	public InvoiceItem findOne(Long id) {
		return iiRepository.findOne(id);
	}

	@Override
	public List<InvoiceItem> findAll() {
		return (List<InvoiceItem>) iiRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		iiRepository.delete(id);
	}

	@Override
	public void delete(InvoiceItem invoiceItem) {
		iiRepository.delete(invoiceItem);
	}

	@Override
	public void deleteAll() {
		iiRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<InvoiceItem> invoiceItems) {
		iiRepository.delete(invoiceItems);
	}

}
