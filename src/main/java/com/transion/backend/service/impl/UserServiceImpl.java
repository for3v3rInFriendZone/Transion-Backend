package com.transion.backend.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.transion.backend.model.User;
import com.transion.backend.repository.UserRepository;
import com.transion.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRep;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRep.save(user);
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRep.findOne(id);
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRep.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}

	
	
}
