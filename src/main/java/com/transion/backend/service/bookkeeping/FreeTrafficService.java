package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.FreeTraffic;

public interface FreeTrafficService {

	public FreeTraffic save(FreeTraffic freeTrafic);
	
	public List<FreeTraffic> save(List<FreeTraffic> freeTraffices);
	
	public FreeTraffic findOne(Long id);
	
	public List<FreeTraffic> findAll();
	
	public void delete(Long id);
	
	public void delete(FreeTraffic freeTraffic);
	
	public void deleteAll();
	
	public void deleteAll(List<FreeTraffic> freeTrafices);
}
