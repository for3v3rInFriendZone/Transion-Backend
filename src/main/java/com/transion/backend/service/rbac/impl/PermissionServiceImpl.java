package com.transion.backend.service.rbac.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.rbac.Permission;
import com.transion.backend.repository.rbac.PermissionRepository;
import com.transion.backend.service.rbac.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	PermissionRepository permissionRepository;

	@Override
	public Permission findOne(Long id) {
		return permissionRepository.findOne(id);
	}

	@Override
	public Permission save(Permission permission) {
		return permissionRepository.save(permission);
	}

	@Override
	public void delete(Long id) {
		permissionRepository.delete(id);
	}
	
}
