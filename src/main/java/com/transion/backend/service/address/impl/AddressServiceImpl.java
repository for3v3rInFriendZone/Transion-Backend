package com.transion.backend.service.address.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.address.Address;
import com.transion.backend.repository.address.AddressRepository;
import com.transion.backend.service.address.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> save(List<Address> addresses) {
		return (List<Address>) addressRepository.save(addresses);
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public List<Address> findAll() {
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		addressRepository.delete(id);
	}

	@Override
	public void delete(Address address) {
		addressRepository.delete(address);
	}

	@Override
	public void deleteAll() {
		addressRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Address> addresses) {
		addressRepository.delete(addresses);
	}

}
