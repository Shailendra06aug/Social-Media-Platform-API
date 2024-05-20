package com.zosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.UserException;
import com.zosh.model.User;
import com.zosh.repository.UserRepository;
import com.zosh.service.UserService;
import com.zosh.serviceImpl.UserServiceImpl;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/api/users")
	public List<User> getAllUsers(){
		
		return userService.getAllUsres();
	}
	
	
	
	@GetMapping("/api/users/{id}")
	public User getUserById(@PathVariable Integer id) throws UserException {
		
		
		return userService.findUserById(id);
	}

	
	@PutMapping("/api/users")
	public User updateUser(@RequestHeader("Authorization") String jwt,@RequestBody User user) throws UserException {
		
		User reqUser= userService.findUserByJwt(jwt);
	  return userService.updateUser(user, reqUser.getId());
	}
	
	
	@PutMapping("/api/users/follow/{usereId2}")
	public User followUserHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer usereId2) throws UserException {
		
		User reqUser= userService.findUserByJwt(jwt);
	    User user= userService.followUser(reqUser.getId(), usereId2);
	         
	    return user;
	}
	
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		return userService.serachUser(query);
	}
	
	
	
	@GetMapping("/api/user/profile")
	public User getUserFromToken(@RequestHeader("Authorization") String jwt) {
		  
//		System.out.println("JwtToken ---"+jwt);	
		User user= userService.findUserByJwt(jwt);
		
		user.setPassword(null);
		
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
