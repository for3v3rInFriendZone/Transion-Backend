package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.TransactionStatus;

@Repository
public interface TransactionStatusRepository extends CrudRepository<TransactionStatus, Long>{

}
