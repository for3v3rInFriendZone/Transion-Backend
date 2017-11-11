package com.transion.backend.service;

import java.util.Date;
import java.util.List;

import com.transion.backend.model.Client;
import com.transion.backend.model.Transaction;
import com.transion.backend.model.scenario.Task;

public interface TransactionService {

	public Transaction save(Transaction transaction);
	
	public List<Transaction> save(List<Transaction> transactions);
	
	public Transaction findOne(Long id);
	
	public List<Transaction> findAll();
	
	public void delete(Long id);
	
	public void delete(Transaction transaction);
	
	public void deleteAll();
	
	public void deleteAll(List<Transaction> transactions);
	
	public List<Transaction> findByClient(Client client);
	
	public List<Transaction> findByTask(Task task);
	
	public Long calculateDelay(Date todaysDate, Date dateToPay);
	
	public List<Transaction> getOnlyPaidTransactions(List<Transaction> transactions);
	
	public List<Transaction> getOnlyNotPaidTransactions(List<Transaction> transactions);
}
