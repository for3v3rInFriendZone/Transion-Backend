package com.transion.backend.service.rbac.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.rbac.Role;
import com.transion.backend.repository.rbac.RoleRepository;
import com.transion.backend.service.rbac.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findOne(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void delete(Long id) {
		roleRepository.delete(id);
	}

}
