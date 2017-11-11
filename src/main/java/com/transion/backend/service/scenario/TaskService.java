package com.transion.backend.service.scenario;

import java.util.List;
import com.transion.backend.model.Client;
import com.transion.backend.model.scenario.Task;

public interface TaskService {

	List<Task> findByClient(Client client);
}
