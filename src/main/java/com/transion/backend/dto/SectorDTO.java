package com.transion.backend.dto;

import java.util.ArrayList;
import java.util.List;

import com.transion.backend.dto.vehicle.VehicleDTO;
import com.transion.backend.model.User;
import com.transion.backend.model.vehicle.Vehicle;

public class SectorDTO {

	private Long id;
	private String name;
	private UserDTO responsibleUser;
	private List<UserDTO> employees = new ArrayList<UserDTO>();
	private List<VehicleDTO> vehicles = new ArrayList<VehicleDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDTO getResponsibleUser() {
		return responsibleUser;
	}

	public void setResponsibleUser(UserDTO responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public List<UserDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<UserDTO> employees) {
		this.employees = employees;
	}

	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}

}
