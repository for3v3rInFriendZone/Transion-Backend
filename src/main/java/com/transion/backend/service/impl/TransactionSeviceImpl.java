package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Transaction;
import com.transion.backend.repository.TransactionRepository;
import com.transion.backend.service.TransactionService;

@Service
public class TransactionSeviceImpl implements TransactionService{

	@Autowired
	TransactionRepository trRepository;
	
	@Override
	public Transaction save(Transaction transaction) {
		return trRepository.save(transaction);
	}

	@Override
	public List<Transaction> save(List<Transaction> transactions) {
		return (List<Transaction>) trRepository.save(transactions);
	}

	@Override
	public Transaction findOne(Long id) {
		return trRepository.findOne(id);
	}

	@Override
	public List<Transaction> findAll() {
		return (List<Transaction>) trRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		trRepository.delete(id);
	}

	@Override
	public void delete(Transaction transaction) {
		trRepository.delete(transaction);
	}

	@Override
	public void deleteAll() {
		trRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Transaction> transactions) {
		trRepository.delete(transactions);
	}

}
