package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.UserType;
import com.transion.backend.repository.UserTypeRepository;
import com.transion.backend.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService{

	@Autowired
	UserTypeRepository utRepository;
	
	@Override
	public UserType save(UserType userType) {
		return utRepository.save(userType);
	}

	@Override
	public List<UserType> save(List<UserType> userTypes) {
		return (List<UserType>) utRepository.save(userTypes);
	}

	@Override
	public UserType findOne(Long id) {
		return utRepository.findOne(id);
	}

	@Override
	public List<UserType> findAll() {
		return (List<UserType>) utRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		utRepository.delete(id);
	}

	@Override
	public void delete(UserType userType) {
		utRepository.delete(userType);
	}

	@Override
	public void deleteAll() {
		utRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<UserType> userTypes) {
		utRepository.delete(userTypes);
	}

}
