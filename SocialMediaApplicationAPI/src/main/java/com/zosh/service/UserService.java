package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.UserException;
import com.zosh.model.User;

public interface UserService {

	public User registerUser(User user);
	
	public User findUserById(Integer userId) throws UserException;
	
	public User findUserByEmail(String email);
	
	public User updateUser(User user, Integer id) throws UserException;
	
	public User followUser(Integer user1, Integer user2) throws UserException;
	
	public List<User> serachUser(String qury);
	
	public List<User> getAllUsres();
	
	public User findUserByJwt(String jwt);
	
	
}
