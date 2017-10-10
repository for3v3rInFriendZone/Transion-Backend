package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Invoice;
import com.transion.backend.repository.InvoiceRepository;
import com.transion.backend.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> save(List<Invoice> invoices) {
		return (List<Invoice>) invoiceRepository.save(invoices);
	}

	@Override
	public Invoice findOne(Long id) {
		return invoiceRepository.findOne(id);
	}

	@Override
	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		invoiceRepository.delete(id);
	}

	@Override
	public void delete(Invoice invoice) {
		invoiceRepository.delete(invoice);
	}

	@Override
	public void deleteAll() {
		invoiceRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Invoice> invoices) {
		invoiceRepository.delete(invoices);
	}

}
