package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.UserType;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Long>{

}
