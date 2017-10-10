package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.ResponsibleUser;
import com.transion.backend.repository.ResponsibleUserRepository;
import com.transion.backend.service.ResponsibleUserService;

@Service
public class ResponsibleUserServiceImpl implements ResponsibleUserService{

	@Autowired
	ResponsibleUserRepository ruRepository;
	
	@Override
	public ResponsibleUser save(ResponsibleUser responsibleUser) {
		return ruRepository.save(responsibleUser);
	}

	@Override
	public List<ResponsibleUser> save(List<ResponsibleUser> responsibleUsers) {
		return (List<ResponsibleUser>) ruRepository.save(responsibleUsers);
	}

	@Override
	public ResponsibleUser findOne(Long id) {
		return ruRepository.findOne(id);
	}

	@Override
	public List<ResponsibleUser> findAll() {
		return (List<ResponsibleUser>) ruRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		ruRepository.delete(id);
	}

	@Override
	public void delete(ResponsibleUser responsibleUser) {
		ruRepository.delete(responsibleUser);
	}

	@Override
	public void deleteAll() {
		ruRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<ResponsibleUser> responsibleUsers) {
		ruRepository.delete(responsibleUsers);
	}

}
