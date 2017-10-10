package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.TransactionStatus;
import com.transion.backend.repository.TransactionStatusRepository;
import com.transion.backend.service.TransactionStatusService;

@Service
public class TransactionStatusServiceImpl implements TransactionStatusService{

	@Autowired
	TransactionStatusRepository trsRepository;
	
	@Override
	public TransactionStatus save(TransactionStatus transactionStatus) {
		return trsRepository.save(transactionStatus);
	}

	@Override
	public List<TransactionStatus> save(List<TransactionStatus> transactionStatuses) {
		return (List<TransactionStatus>) trsRepository.save(transactionStatuses);
	}

	@Override
	public TransactionStatus findOne(Long id) {
		return trsRepository.findOne(id);
	}

	@Override
	public List<TransactionStatus> findAll() {
		return (List<TransactionStatus>) trsRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		trsRepository.delete(id);
	}

	@Override
	public void delete(TransactionStatus transactionStatus) {
		trsRepository.delete(transactionStatus);
	}

	@Override
	public void deleteAll() {
		trsRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<TransactionStatus> transactionStatuses) {
		trsRepository.delete(transactionStatuses);
	}

}
