package com.transion.backend.service.impl;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Client;
import com.transion.backend.model.Transaction;
import com.transion.backend.repository.ClientRepository;
import com.transion.backend.repository.TransactionRepository;
import com.transion.backend.service.ClientService;
import com.transion.backend.service.TransactionService;

@Service
public class TransactionSeviceImpl implements TransactionService{

	@Autowired
	TransactionRepository trRepository;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public Transaction save(Transaction transaction) {
		transaction.setDelay(this.calculateDelay(Calendar.getInstance().getTime(), transaction.getLastDayToPay()));
		return trRepository.save(transaction);
	}

	@Override
	public List<Transaction> save(List<Transaction> transactions) {
		for(Transaction tran: transactions) {
			tran.setDelay(this.calculateDelay(Calendar.getInstance().getTime(), tran.getLastDayToPay()));
		}
		return (List<Transaction>) trRepository.save(transactions);
	}

	@Override
	public Transaction findOne(Long id) {
		Transaction transaction = trRepository.findOne(id);
		this.save(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> findAll() {
		List<Transaction> transactions = (List<Transaction>) trRepository.findAll();
		for(Transaction tran: transactions) {
			tran.setDelay(this.calculateDelay(Calendar.getInstance().getTime(), tran.getLastDayToPay()));
		}
		this.save(transactions);
		return transactions;
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

	@Override
	public List<Transaction> findByClient(Client client) {
	/*	List<Transaction> transactions = em.createNativeQuery("SELECT * FROM TRANSACTION WHERE CLIENT_ID = ?1 ORDER BY CREATIONDATE ASC", Transaction.class)
				.setParameter(1, client.getId()).getResultList();
		return transactions;*/
		return trRepository.findByClientOrderByCreationDateAsc(client);
	}

	@Override
	public Long calculateDelay(Date todaysDate, Date dateToPay) {
		Date newDate = new Date(dateToPay.getTime());
		return ChronoUnit.DAYS.between(newDate.toInstant(), todaysDate.toInstant());
	}

	@Override
	public List<Transaction> getOnlyPaidTransactions(List<Transaction> transactions) {
		// TODO Auto-generated method stub
		List<Transaction> paid = new ArrayList<Transaction>();
		for(Transaction transaction : transactions) {
			if(transaction.getPaidDate() != null) {
				paid.add(transaction);
			}
		}
		return paid;
	}

	@Override
	public List<Transaction> getOnlyNotPaidTransactions(List<Transaction> transactions) {
		// TODO Auto-generated method stub
		List<Transaction> notPaid = new ArrayList<Transaction>();
		for(Transaction transaction : transactions) {
			if(transaction.getPaidDate() == null) {
				notPaid.add(transaction);
			}
		}
		return notPaid;
	}

}
