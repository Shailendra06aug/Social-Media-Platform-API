package com.zosh.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zosh.config.JwtProvider;
import com.zosh.config.jwtValidator;
import com.zosh.exceptions.UserException;
import com.zosh.model.User;
import com.zosh.repository.UserRepository;
import com.zosh.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUsres() {
		
		return userRepository.findAll();
	}

	
	@Override
	public User registerUser(User user) {
		
		User user2= new User();

		user2.setId(user.getId());
		user2.setFistName(user.getFistName());
		user2.setLastName(user.getLastName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setGender(user.getGender());
		
		User savedUser= userRepository.save(user2);
		return savedUser;
		
//		return userRepository.save(user);
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
		Optional<User> user= userRepository.findById(userId);
		
		if (user.isPresent()) {
		   return user.get();
		}
		
		throw new UserException("user not exits with userId: "+userId);
	}

	
	@Override
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws UserException {
	    
	    User reUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);
		
		user2.getFollowers().add(reUser.getId());
		reUser.getFollowings().add(user2.getId());
		
		userRepository.save(reUser);
		userRepository.save(user2);
		
		return reUser;
	}

	@Override
	public List<User> serachUser(String qury) {
		
		return userRepository.searchUser(qury);
	}
	
	@Override
	public User updateUser(User user, Integer id) throws UserException {
		
		Optional<User> user1= userRepository.findById(id);
		
		if (user1.isEmpty()) {
			throw new UserException("user not exit with id:"+id);
	}
		
		User oldUser = user1.get();
		
		if (user.getFistName()!=null) {
			oldUser.setFistName(user.getFistName());
		}
		
		if (user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		
		if (user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		
		if (user.getPassword()!=null) {
			oldUser.setPassword(passwordEncoder.encode(user.getPassword()) );
		}
		
		if (user.getGender()!=null) {
			oldUser.setGender(user.getGender());
		}
		
		 return userRepository.save(oldUser);
		
	}


	@Override
	public User findUserByJwt(String jwt) {
		
		String email= JwtProvider.getEmailFromJwtToekn(jwt);
		User user= userRepository.findByEmail(email);
		
		return user;
	}

	
	
	
}
