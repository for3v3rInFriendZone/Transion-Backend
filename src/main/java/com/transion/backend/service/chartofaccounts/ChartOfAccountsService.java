package com.transion.backend.service.chartofaccounts;

import java.util.List;

import com.transion.backend.model.chartofaccounts.ChartOfAccounts;

public interface ChartOfAccountsService {
	
	public ChartOfAccounts save(ChartOfAccounts charts);
	
	public List<ChartOfAccounts> save(List<ChartOfAccounts> charts);
	
	public ChartOfAccounts findOne(Long id);
	
	public List<ChartOfAccounts> findAll();
	
	public void delete(Long id);
	
	public void delete(ChartOfAccounts charts);
	
	public void deleteAll();
	
	public void deleteAll(List<ChartOfAccounts> charts);
}
