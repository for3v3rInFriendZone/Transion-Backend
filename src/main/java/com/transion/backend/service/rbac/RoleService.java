package com.transion.backend.service.rbac;

import com.transion.backend.model.rbac.Role;

public interface RoleService {

	public Role findOne(Long id);
	
	public Role save(Role role);
	
	public void delete(Long id);
}
