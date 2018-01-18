package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Measure;
import com.transion.backend.repository.MeasureRepository;
import com.transion.backend.service.MeasureService;

@Service
public class MeasureServiceImpl implements MeasureService{

	@Autowired
	MeasureRepository measRepo;
	
	@Override
	public List<Measure> findAll() {
		// TODO Auto-generated method stub
		return (List<Measure>) measRepo.findAll();
	}

}
