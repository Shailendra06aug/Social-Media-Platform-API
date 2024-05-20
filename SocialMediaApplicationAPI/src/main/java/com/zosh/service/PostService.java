package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.PostException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Post;

public interface PostService {

	public Post createNewPost(Post post, Integer usrerId)throws PostException, UserException;
	
	public List<Post> findPostByUserId(Integer userId);
	
	public String deletePost(Integer postId,Integer userId)throws PostException, UserException;
	
	public Post findPostById(Integer postId) throws PostException;
	
	public List<Post> findAllPost();
	
	public Post savedPost(Integer postId, Integer userId) throws PostException, UserException;
	
	public Post likePost(Integer postId, Integer userId) throws PostException, UserException;
	
//	public List<Post> likePost(Integer postId, Integer userId);
	

	
	
}
