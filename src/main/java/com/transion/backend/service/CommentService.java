package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Comment;

public interface CommentService {

	public Comment save(Comment comment);
	
	public List<Comment> save(List<Comment> comments);
	
	public Comment findOne(Long id);
	
	public List<Comment> findAll();
	
	public void delete(Long id);
	
	public void delete(Comment comment);
	
	public void deleteAll();
	
	public void deleteAll(List<Comment> comments);
}
