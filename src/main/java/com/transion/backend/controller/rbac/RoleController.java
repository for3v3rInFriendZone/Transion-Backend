package com.transion.backend.controller.rbac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transion.backend.model.rbac.Role;
import com.transion.backend.service.rbac.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Role> save(@RequestBody Role role){
		return new ResponseEntity<Role>(roleService.save(role), HttpStatus.CREATED);
	}
}
