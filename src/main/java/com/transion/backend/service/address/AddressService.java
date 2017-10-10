package com.transion.backend.service.address;

import java.util.List;

import com.transion.backend.model.address.Address;

public interface AddressService {

	public Address save(Address address);
	
	public List<Address> save(List<Address> addresses);
	
	public Address findOne(Long id);
	
	public List<Address> findAll();
	
	public void delete(Long id);
	
	public void delete(Address address);
	
	public void deleteAll();
	
	public void deleteAll(List<Address> addresses);
}
