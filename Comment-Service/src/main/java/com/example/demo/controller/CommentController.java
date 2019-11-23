package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comments;
import com.example.demo.model.Replies;
import com.example.demo.repository.CommentRepository;

@RestController
public class CommentController {
	public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
	
	@Autowired
	CommentRepository commentRepository;
	
	@PostMapping(value= "/add", produces=APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Comments addUser(@RequestBody Comments comment) {
	
    	return commentRepository.save(comment);
        
		
	}
	@GetMapping("/getall")
	public List<Comments> getAll() {
		return commentRepository.findAll();
	}
	
	@GetMapping("/find/{apartmentId}")
	public List<Comments> findByAptId(@PathVariable Integer apartmentId) {
		return commentRepository.findByApartmentId(apartmentId);
	}
	
	@PostMapping("/reply/{commentId}")
	public String addComment(@RequestBody Replies reply,@PathVariable Integer commentId) {
		Comments comment=commentRepository.findById(commentId).get();
		comment.addReply(reply);
		commentRepository.save(comment);
		return "Comment Added";
		
	}

}
