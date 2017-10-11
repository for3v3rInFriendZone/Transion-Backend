package com.transion.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transion.backend.model.Comment;
import com.transion.backend.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getAll(){
		return new ResponseEntity<List<Comment>>(commentService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Comment> save(@RequestBody Comment comment){
		if(comment == null) {
			logger.error("Comment doesn't exist.");
			return new ResponseEntity<Comment>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Comment>(commentService.save(comment), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Comment> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null");
			return new ResponseEntity<Comment>(HttpStatus.BAD_REQUEST);
		}
		
		Comment comment = commentService.findOne(id);
		
		if(comment == null) {
			logger.error("Comment doesn't exist.");
			return new ResponseEntity<Comment>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Comment> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null");
			return new ResponseEntity<Comment>(HttpStatus.BAD_REQUEST);
		}
		
		Comment comment = commentService.findOne(id);
		
		if(comment == null) {
			logger.error("Comment doesn't exist.");
			return new ResponseEntity<Comment>(HttpStatus.BAD_REQUEST);
		}
		
		commentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Comment> deleteAll(){
		commentService.deleteAll();
		return new ResponseEntity<Comment>(HttpStatus.OK);
	}
}
