package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.TransactionStatus;

public interface TransactionStatusService {
	
	public TransactionStatus save(TransactionStatus transactionStatus);
	
	public List<TransactionStatus> save(List<TransactionStatus> transactionStatuses);
	
	public TransactionStatus findOne(Long id);
	
	public List<TransactionStatus> findAll();
	
	public void delete(Long id);
	
	public void delete(TransactionStatus transactionStatus);
	
	public void deleteAll();
	
	public void deleteAll(List<TransactionStatus> transactionStatuses);
}
