package com.transion.backend.service.scenario.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Client;
import com.transion.backend.model.scenario.Task;
import com.transion.backend.repository.scenario.TaskRepository;
import com.transion.backend.service.scenario.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepo;
	
	@Override
	public List<Task> findByClient(Client client) {
		// TODO Auto-generated method stub
		return taskRepo.findByClient(client);
	}

}
