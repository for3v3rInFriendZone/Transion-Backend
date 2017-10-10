package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Document;
import com.transion.backend.repository.DocumentRepository;
import com.transion.backend.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	DocumentRepository documentRepository;
	
	@Override
	public Document save(Document document) {
		return documentRepository.save(document);
	}

	@Override
	public List<Document> save(List<Document> documents) {
		return (List<Document>) documentRepository.save(documents);
	}

	@Override
	public Document findOne(Long id) {
		return documentRepository.findOne(id);
	}

	@Override
	public List<Document> findAll() {
		return (List<Document>) documentRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		documentRepository.delete(id);
	}

	@Override
	public void delete(Document document) {
		documentRepository.delete(document);
	}

	@Override
	public void deleteAll() {
		documentRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Document> documents) {
		documentRepository.delete(documents);
	}

}
