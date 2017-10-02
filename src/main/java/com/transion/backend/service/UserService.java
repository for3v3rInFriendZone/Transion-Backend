package com.transion.backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.transion.backend.model.User;

public interface UserService extends UserDetailsService{
	
	public User save(User user);

	public User findOne(Long id);

	public Iterable<User> findAll();

	public void delete(Long id);

	public void delete(User user);

	public void deleteAll();
	
	public String passwordEncrypt(String password);

	public Boolean checkPassword(String rawPassword, String encodedPassword);
	
	public User findByUsername(String username);

}
