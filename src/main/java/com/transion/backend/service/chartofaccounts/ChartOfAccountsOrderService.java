package com.transion.backend.service.chartofaccounts;

import java.util.List;

import com.transion.backend.model.chartofaccounts.ChartOfAccountsOrder;

public interface ChartOfAccountsOrderService {

	public ChartOfAccountsOrder save(ChartOfAccountsOrder order);
	
	public List<ChartOfAccountsOrder> save(List<ChartOfAccountsOrder> orders);
	
	public ChartOfAccountsOrder findOne(Long id);
	
	public List<ChartOfAccountsOrder> findAll();
	
	public void delete(Long id);
	
	public void delete(ChartOfAccountsOrder order);
	
	public void deleteAll();
	
	public void deleteAll(List<ChartOfAccountsOrder> orders);

}
