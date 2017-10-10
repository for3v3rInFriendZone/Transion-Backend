package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Report;

public interface ReportService {

	public Report save(Report report);
	
	public List<Report> save(List<Report> reports);
	
	public Report findOne(Long id);
	
	public List<Report> findAll();
	
	public void delete(Long id);
	
	public void delete(Report report);
	
	public void deleteAll();
	
	public void deleteAll(List<Report> reports);
}
