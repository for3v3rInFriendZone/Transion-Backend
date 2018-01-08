package com.transion.backend.service.chartofaccounts;

import java.util.List;

import com.transion.backend.model.chartofaccounts.ChartOfAccountsClass;

public interface ChartOfAccountsClassService {

	public ChartOfAccountsClass save(ChartOfAccountsClass clazz);
	
	public List<ChartOfAccountsClass> save(List<ChartOfAccountsClass> classes);
	
	public ChartOfAccountsClass findOne(Long id);
	
	public List<ChartOfAccountsClass> findAll();
	
	public void delete(Long id);
	
	public void delete(ChartOfAccountsClass clazz);
	
	public void deleteAll();
	
	public void deleteAll(List<ChartOfAccountsClass> classes);
}
