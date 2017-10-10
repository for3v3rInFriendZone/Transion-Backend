package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Document;

public interface DocumentService {

	public Document save(Document document);
	
	public List<Document> save(List<Document> documents);
	
	public Document findOne(Long id);
	
	public List<Document> findAll();
	
	public void delete(Long id);
	
	public void delete(Document document);
	
	public void deleteAll();
	
	public void deleteAll(List<Document> documents);
}
