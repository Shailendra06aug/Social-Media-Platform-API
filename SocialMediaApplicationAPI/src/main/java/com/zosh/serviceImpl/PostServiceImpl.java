package com.zosh.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.exceptions.PostException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Post;
import com.zosh.model.User;
import com.zosh.repository.PostRepository;
import com.zosh.repository.UserRepository;
import com.zosh.service.PostService;
import com.zosh.service.UserService;

@Service
public class PostServiceImpl implements PostService  {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	
	@Override
	public Post createNewPost(Post post, Integer usrerId) throws PostException, UserException {
	
		User user= userService.findUserById(usrerId);
		
		Post newPost = new Post();
		
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		newPost.setCreatedAt(LocalDateTime.now());
		newPost.setUser(user);
		
		return postRepository.save(newPost);
	}
	
	
	@Override
	public Post findPostById(Integer postId) throws PostException {
		Optional<Post> opt = postRepository.findById(postId);
		if (opt.isEmpty()) {
			throw new PostException("post not found with id:"+postId);
		}
		
		return opt.get();
	}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		
		return postRepository.findPostByUserId(userId);
	}

	
	@Override
	public String deletePost(Integer postId, Integer userId) throws PostException, UserException {
		Post post = findPostById(postId);
		User user= userService.findUserById(userId);
		
		if (post.getUser().getId()!=user.getId()) {
			throw new PostException("user  can't deleted another user post");
		}
		
		postRepository.delete(post);
		return "post deleted successfully" ;
	}

	

	@Override
	public List<Post> findAllPost() {
		
		return postRepository.findAll();
	}

	@Override
	public Post savedPost(Integer postId, Integer userId) throws PostException, UserException {
		
	  Post post= findPostById(postId);
	  User user= userService.findUserById(userId);
		
	  if (user.getSavedPost().contains(post)) {
		
		  user.getSavedPost().remove(user);
	}
	  else {
		  user.getSavedPost().add(post);
	}
	  
		userRepository.save(user);
		return post;
	}

	@Override
	public Post likePost(Integer postId, Integer userId) throws PostException, UserException {
		
		Post post = findPostById(postId);
		User user= userService.findUserById(userId);
		
		if (post.getLiked().contains(user)) {
			post.getLiked().remove(user);
		}
		else {
			post.getLiked().add(user);
		}
		
		return postRepository.save(post);
	}
	
	
}
