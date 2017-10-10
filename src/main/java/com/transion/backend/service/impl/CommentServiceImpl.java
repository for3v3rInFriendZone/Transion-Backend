package com.transion.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.Comment;
import com.transion.backend.repository.CommentRepository;
import com.transion.backend.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> save(List<Comment> comments) {
		return (List<Comment>) commentRepository.save(comments);
	}

	@Override
	public Comment findOne(Long id) {
		return commentRepository.findOne(id);
	}

	@Override
	public List<Comment> findAll() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		commentRepository.delete(id);
	}

	@Override
	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}

	@Override
	public void deleteAll() {
		commentRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Comment> comments) {
		commentRepository.delete(comments);
	}

}
