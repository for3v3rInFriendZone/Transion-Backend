package com.transion.backend.repository.rbac;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.rbac.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
