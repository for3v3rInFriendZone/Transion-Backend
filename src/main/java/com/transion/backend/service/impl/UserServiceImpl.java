package com.transion.backend.service.impl;

import org.modelmapper.ModelMapper;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		return mapDTO.map(userRep.save(user), UserDTO.class);
	}

	@Override
	public UserDTO findOne(Long id) {
		return mapDTO.map(userRep.findOne(id), UserDTO.class);
	}

	@Override
	public Iterable<User> findAll() {
		return userRep.findAll();
	}

	@Override
	public void delete(Long id) {
		userRep.delete(id);
	}

	@Override
	public void delete(User user) {
		userRep.delete(user);
	}

	@Override
	public void deleteAll() {
		userRep.deleteAll();
	}   

	@Override
	public String passwordEncrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	@Override
	public Boolean checkPassword(String rawPassword, String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	@Override
	public User findByUsername(String username) {
		return userRep.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRep.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}

	
	
}
