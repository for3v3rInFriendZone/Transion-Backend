package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Dispute;

public interface DisputeService {

	public Dispute save(Dispute dispute);
	
	public List<Dispute> save(List<Dispute> disputes);
	
	public Dispute findOne(Long id);
	
	public List<Dispute> findAll();
	
	public void delete(Long id);
	
	public void delete(Dispute dispute);
	
	public void deleteAll();
	
	public void deleteAll(List<Dispute> disputes);
}
