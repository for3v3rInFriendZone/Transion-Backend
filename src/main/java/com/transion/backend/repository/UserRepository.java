package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.transion.backend.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}
