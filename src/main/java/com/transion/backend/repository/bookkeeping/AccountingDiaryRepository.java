package com.transion.backend.repository.bookkeeping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.bookkeeping.AccountingDiary;

@Repository
public interface AccountingDiaryRepository extends CrudRepository<AccountingDiary, Long>{

}
