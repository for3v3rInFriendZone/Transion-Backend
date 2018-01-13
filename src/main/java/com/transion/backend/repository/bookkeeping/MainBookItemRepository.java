package com.transion.backend.repository.bookkeeping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.bookkeeping.MainBookItem;

@Repository
public interface MainBookItemRepository extends CrudRepository<MainBookItem, Long>{

}
