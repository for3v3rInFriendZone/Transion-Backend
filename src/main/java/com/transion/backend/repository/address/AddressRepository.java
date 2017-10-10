package com.transion.backend.repository.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.address.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}
