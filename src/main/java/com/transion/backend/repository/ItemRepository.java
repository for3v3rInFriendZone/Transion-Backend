package com.transion.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Client;
import com.transion.backend.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
	
	public List<Item> findBySupplier(Client client);

}
