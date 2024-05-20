package com.zosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.CommentsException;
import com.zosh.exceptions.PostException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Comment;
import com.zosh.model.User;
import com.zosh.service.CommentService;
import com.zosh.service.UserService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/api/comments/post/{postId}")
	public Comment createdfComment(@RequestBody Comment comment,@RequestHeader("Authorization") String jwt, @PathVariable Integer postId) throws CommentsException, UserException, PostException {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Comment cretedComment= commentService.createComment(comment, postId, reqUser.getId());
		
		return cretedComment;
	}
	
	@PutMapping("/api/comments/like/{commentId}")
	public Comment likeComment(@PathVariable Integer commentId, @RequestHeader("Authorization") String jwt) throws CommentsException, UserException {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Comment likedComment= commentService.likeComment(commentId,reqUser.getId());
		
		return  likedComment;
	}
	
	@GetMapping("/api/comments/allComments")
	public List<Comment> findAllComment(){
		
		return commentService.findAllComment();
	}
	
	
	
}
