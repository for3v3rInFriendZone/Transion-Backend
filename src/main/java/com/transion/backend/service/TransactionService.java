package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Transaction;

public interface TransactionService {

	public Transaction save(Transaction transaction);
	
	public List<Transaction> save(List<Transaction> transactions);
	
	public Transaction findOne(Long id);
	
	public List<Transaction> findAll();
	
	public void delete(Long id);
	
	public void delete(Transaction transaction);
	
	public void deleteAll();
	
	public void deleteAll(List<Transaction> transactions);
}
