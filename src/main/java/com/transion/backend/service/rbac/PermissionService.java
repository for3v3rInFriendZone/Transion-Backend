package com.transion.backend.service.rbac;

import com.transion.backend.model.rbac.Permission;

public interface PermissionService {
	
	public Permission findOne(Long id);
	
	public Permission save(Permission permission);
	
	public void delete(Long id);

}
