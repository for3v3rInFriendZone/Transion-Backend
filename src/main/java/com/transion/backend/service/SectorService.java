package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Sector;

public interface SectorService {

	public Sector save(Sector sector);
	
	public List<Sector> save(List<Sector> sectors);
	
	public Sector findOne(Long id);
	
	public List<Sector> findAll();
	
	public void delete(Long id);
	
	public void delete(Sector sector);
	
	public void deleteAll();
	
	public void deleteAll(List<Sector> sectors);
}
