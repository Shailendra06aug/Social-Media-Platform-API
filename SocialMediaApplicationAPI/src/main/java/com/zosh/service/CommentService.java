package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.CommentsException;
import com.zosh.exceptions.PostException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Comment;

public interface CommentService {

	public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentsException, UserException, PostException;
	
	public Comment findCommentById(Integer commentId) throws CommentsException;
	
	public Comment likeComment(Integer commentId, Integer userId) throws CommentsException, UserException;
	
	public List<Comment> findAllComment();
}
