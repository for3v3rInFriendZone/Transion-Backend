package com.transion.backend.service.bookkeeping;

import java.util.List;

import com.transion.backend.model.bookkeeping.Change;

public interface ChangeService {

	public Change save(Change change);
	
	public List<Change> save(List<Change> changes);
	
	public Change findOne(Long id);
	
	public List<Change> findAll();
	
	public void delete(Long id);
	
	public void delete(Change change);
	
	public void deleteAll();
	
	public void deleteAll(List<Change> changes);
}
