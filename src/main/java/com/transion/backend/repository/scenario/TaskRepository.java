package com.transion.backend.repository.scenario;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Client;
import com.transion.backend.model.scenario.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

	List<Task> findByClient(Client client);
}
