package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

}
