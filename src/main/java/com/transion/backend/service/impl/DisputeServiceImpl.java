package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Dispute;
import com.transion.backend.repository.DisputeRepository;
import com.transion.backend.service.DisputeService;

@Service
public class DisputeServiceImpl implements DisputeService{

	@Autowired
	DisputeRepository disputeRepository;
	
	@Override
	public Dispute save(Dispute dispute) {
		return disputeRepository.save(dispute);
	}

	@Override
	public List<Dispute> save(List<Dispute> disputes) {
		return (List<Dispute>) disputeRepository.save(disputes);
	}

	@Override
	public Dispute findOne(Long id) { 
		return disputeRepository.findOne(id);
	}

	@Override
	public List<Dispute> findAll() {
		return (List<Dispute>) disputeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		disputeRepository.delete(id);
	}

	@Override
	public void delete(Dispute dispute) {
		disputeRepository.delete(dispute);
	}

	@Override
	public void deleteAll() {
		disputeRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Dispute> disputes) {
		disputeRepository.delete(disputes);
	}

}
