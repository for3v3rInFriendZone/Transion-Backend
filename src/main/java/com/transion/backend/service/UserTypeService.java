package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.UserType;

public interface UserTypeService {

	public UserType save(UserType userType);
	
	public List<UserType> save(List<UserType> userTypes);
	
	public UserType findOne(Long id);
	
	public List<UserType> findAll();
	
	public void delete(Long id);
	
	public void delete(UserType userType);
	
	public void deleteAll();
	
	public void deleteAll(List<UserType> userTypes);
}
