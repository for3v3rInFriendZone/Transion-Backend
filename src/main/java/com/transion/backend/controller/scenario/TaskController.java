package com.transion.backend.controller.scenario;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transion.backend.model.Client;
import com.transion.backend.model.Transaction;
import com.transion.backend.model.scenario.Task;
import com.transion.backend.service.ClientService;
import com.transion.backend.service.scenario.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	TaskService taskSer;
	
	@Autowired
	ClientService clientSer;
	
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> getTaskByClient(@PathVariable Long clientId) {
		if(clientId == null) {
			logger.error("Client does not exist");
			return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
		}
		Client client = clientSer.findOne(clientId);
		
		if (client == null) {
			logger.error("Client is null.");
			return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Task>>(taskSer.findByClient(client), HttpStatus.OK);
	}
}
