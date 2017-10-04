package com.transion.backend.service;

import com.transion.backend.dto.UserDTO;
import com.transion.backend.model.User;

public interface UserService{
	
	public UserDTO save(User user);

	public UserDTO findOne(Long id);

	public Iterable<User> findAll();

	public void delete(Long id);

	public void delete(User user);

	public void deleteAll();
	
	public String passwordEncrypt(String password);

	public Boolean checkPassword(String rawPassword, String encodedPassword);
	
	public User findByUsername(String username);

}
