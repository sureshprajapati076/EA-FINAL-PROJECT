package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Comments;

public interface CommentRepository extends MongoRepository<Comments, Integer> {
	
	
	 public List<Comments> findByApartmentId(Integer apartmentId);
	
}
