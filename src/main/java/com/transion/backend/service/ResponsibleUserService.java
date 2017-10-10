package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.ResponsibleUser;

public interface ResponsibleUserService {

	public ResponsibleUser save(ResponsibleUser responsibleUser);
	
	public List<ResponsibleUser> save(List<ResponsibleUser> responsibleUsers);
	
	public ResponsibleUser findOne(Long id);
	
	public List<ResponsibleUser> findAll();
	
	public void delete(Long id);
	
	public void delete(ResponsibleUser responsibleUser);
	
	public void deleteAll();
	
	public void deleteAll(List<ResponsibleUser> responsibleUsers);
}
