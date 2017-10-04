package com.transion.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.transion.backend.dto.UserDTO;
import com.transion.backend.model.User;
import com.transion.backend.repository.UserRepository;
import com.transion.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRep;
	
	@Autowired
	ModelMapper mapDTO;
	
	@Override
	public UserDTO save(User user) {
		// TODO Auto-generated method stub
		return mapDTO.map(userRep.save(user), UserDTO.class);
	}

	@Override
	public UserDTO findOne(Long id) {
		// TODO Auto-generated method stub
		return mapDTO.map(userRep.findOne(id), UserDTO.class);
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRep.delete(id);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userRep.delete(user);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userRep.deleteAll();
	}   

	@Override
	public String passwordEncrypt(String password) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	@Override
	public Boolean checkPassword(String rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRep.findByUsername(username);
	}

	
	
}
