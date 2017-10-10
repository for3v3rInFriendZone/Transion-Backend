package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
