package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Sector;
import com.transion.backend.repository.SectorRepository;
import com.transion.backend.service.SectorService;

@Service
public class SectorServiceImpl implements SectorService{

	@Autowired
	SectorRepository sectorRepository;
	
	@Override
	public Sector save(Sector sector) {
		return sectorRepository.save(sector);
	}

	@Override
	public List<Sector> save(List<Sector> sectors) {
		return (List<Sector>) sectorRepository.save(sectors);
	}

	@Override
	public Sector findOne(Long id) {
		return sectorRepository.findOne(id);
	}

	@Override
	public List<Sector> findAll() {
		return (List<Sector>) sectorRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		sectorRepository.delete(id);
	}

	@Override
	public void delete(Sector sector) {
		sectorRepository.delete(sector);
	}

	@Override
	public void deleteAll() {
		sectorRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Sector> sectors) {
		sectorRepository.delete(sectors);
	}

}
