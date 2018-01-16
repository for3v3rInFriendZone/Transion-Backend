package com.transion.backend.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.transion.backend.model.Tax;
import com.transion.backend.model.User;
import com.transion.backend.service.TaxService;
import com.transion.backend.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userSer;

	@Autowired
	ThreadPoolTaskScheduler tpts;
	
	@Autowired
	TaxService taxSer;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		
		/*
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 14);
		cal.set(Calendar.MINUTE, 02);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		tpts.schedule(new RunnableTask("Specific time tax saved -> 2:02pm", taxSer), cal.getTime());  */

		List<User> users = (List<User>) userSer.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/notLoged", params = { "logedUser" }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getOnlyNotLogedUsers(@RequestParam(value = "logedUser") String logedUser) {
		if (logedUser == null) {
			logger.error("User email has not been sent.");
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}

		List<User> users = (List<User>) userSer.findAll();
		for (User u : users) {
			if (u.getEmail().equals(logedUser)) {
				users.remove(u);
				break;
			}
		}

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

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		user.setPassword(userSer.passwordEncrypt(user.getPassword()));

		return new ResponseEntity<User>(userSer.save(user), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable Long id) {
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}

		User user = userSer.findOne(id);

		if (user == null) {
			logger.error("User doesn't exist.");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userSer.delete(id);
		return new ResponseEntity<User>(new User(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAll() {
		userSer.deleteAll();
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		User userDB = userSer.findByUsername(user.getUsername());
		/*
		 * if(!userSer.checkPassword(user.getPassword(), userDB.getPassword())){
		 * user.setPassword(userSer.passwordEncrypt(user.getPassword())); }
		 */
		return new ResponseEntity<User>(userSer.save(user), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable Long id) {

		return new ResponseEntity<User>(userSer.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET, params = { "username" })
	public ResponseEntity<User> findOneByUsername(@RequestParam(value = "username") String username) {

		return new ResponseEntity<User>(userSer.findByUsername(username), HttpStatus.OK);
	}
}
