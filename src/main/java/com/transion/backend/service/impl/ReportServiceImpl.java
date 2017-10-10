package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Report;
import com.transion.backend.repository.ReportRepository;
import com.transion.backend.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	ReportRepository reportRepository;
	
	@Override
	public Report save(Report report) {
		return reportRepository.save(report);
	}

	@Override
	public List<Report> save(List<Report> reports) {
		return (List<Report>) reportRepository.save(reports);
	}

	@Override
	public Report findOne(Long id) {
		return reportRepository.findOne(id);
	}

	@Override
	public List<Report> findAll() {
		return (List<Report>) reportRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		reportRepository.delete(id);
	}

	@Override
	public void delete(Report report) {
		reportRepository.delete(report);
	}

	@Override
	public void deleteAll() {
		reportRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Report> reports) {
		reportRepository.delete(reports);
	}

}
