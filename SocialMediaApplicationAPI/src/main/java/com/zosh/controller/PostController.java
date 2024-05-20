package com.zosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.PostException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Post;
import com.zosh.model.User;
import com.zosh.response.ApiResponse;
import com.zosh.service.PostService;
import com.zosh.service.UserService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createNewPost(@RequestHeader("Authorization") String jwt, @RequestBody Post post) throws PostException, UserException{
		
		User reqUser= userService.findUserByJwt(jwt);
		
		Post creatPost= postService.createNewPost(post, reqUser.getId());
		
		return new ResponseEntity<Post>(creatPost,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/api/posts/{postId}")
	public ResponseEntity<Post>  findPostById(@PathVariable Integer postId) throws PostException{
		Post post = postService.findPostById(postId);
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/api/posts/user/{userId}")
	public ResponseEntity<List<Post>> findUserPost(@PathVariable("userId") Integer userId){
		
		List<Post> post = postService.findPostByUserId(userId);
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/api//posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws PostException, UserException{
		
		User reqUser= userService.findUserByJwt(jwt);
		
		String message= postService.deletePost(postId, reqUser.getId());
		
		ApiResponse apiResponse= new ApiResponse(message,true);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/api/posts")
	public ResponseEntity<List<Post>> findAllPost(){
		
		List<Post> post= postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
	}
	
	@PutMapping("api/posts/save/{postId}")
	public ResponseEntity<Post> savedPost( @PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws PostException, UserException{
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Post post =postService.savedPost(postId, reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/api/posts/like/{postId}")
	public ResponseEntity<Post> likedPost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws PostException, UserException{
	
		User reqUser = userService.findUserByJwt(jwt);
		Post post = postService.likePost(postId, reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
