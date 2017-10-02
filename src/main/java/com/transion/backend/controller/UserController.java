package com.transion.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transion.backend.model.User;
import com.transion.backend.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userSer;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = (List<User>) userSer.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK); 
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> checkUserLogin(@RequestBody User user) {

		User userDB = userSer.findByUsername(user.getUsername());
		if (userDB != null && userSer.checkPassword(user.getPassword(), userDB.getPassword())) {
			return new ResponseEntity<User>(userDB, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);

	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		
		user.setPassword(userSer.passwordEncrypt(user.getPassword()));
		
		return new ResponseEntity<User>(userSer.save(user), HttpStatus.CREATED);
	}
}