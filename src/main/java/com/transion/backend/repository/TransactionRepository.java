package com.transion.backend.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Client;
import com.transion.backend.model.Transaction;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
	
	List<Transaction> findByClientOrderByCreationDateAsc(Client client);

}
