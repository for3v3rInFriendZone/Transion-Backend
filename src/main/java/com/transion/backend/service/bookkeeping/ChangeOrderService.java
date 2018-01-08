package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.ChangeOrder;


public interface ChangeOrderService {
	
	public ChangeOrder save(ChangeOrder order);
	
	public List<ChangeOrder> save(List<ChangeOrder> orders);
	
	public ChangeOrder findOne(Long id);
	
	public List<ChangeOrder> findAll();
	
	public void delete(Long id);
	
	public void delete(ChangeOrder diary);
	
	public void deleteAll();
	
	public void deleteAll(List<ChangeOrder> orders);
}
