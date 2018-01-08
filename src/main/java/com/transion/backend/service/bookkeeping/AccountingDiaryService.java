package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.AccountingDiary;

public interface AccountingDiaryService {

	public AccountingDiary save(AccountingDiary diary);
	
	public List<AccountingDiary> save(List<AccountingDiary> diaries);
	
	public AccountingDiary findOne(Long id);
	
	public List<AccountingDiary> findAll();
	
	public void delete(Long id);
	
	public void delete(AccountingDiary diary);
	
	public void deleteAll();
	
	public void deleteAll(List<AccountingDiary> diaries);
}
