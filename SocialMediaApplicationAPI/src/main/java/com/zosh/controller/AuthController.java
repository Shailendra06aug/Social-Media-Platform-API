package com.zosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.config.CustomUserDetails;
import com.zosh.config.JwtProvider;
import com.zosh.model.User;
import com.zosh.repository.UserRepository;
import com.zosh.request.LoginRequest;
import com.zosh.response.AuthResponse;
import com.zosh.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
   private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetails customUserDetails;
	
	
	@PostMapping("/signup")
	public AuthResponse registerUser(@RequestBody User user) throws Exception {
		
		User isExitUser= userRepository.findByEmail(user.getEmail());
		
		if (isExitUser!=null) {
			throw new Exception("email already used with another account");
		}
		
		User user2= new User();

		user2.setId(user.getId());
		user2.setFistName(user.getFistName());
		user2.setLastName(user.getLastName());
		user2.setEmail(user.getEmail());
		user2.setPassword(passwordEncoder.encode(user.getPassword()));
		user2.setGender(user.getGender());
		
		User savedUser= userRepository.save(user2);
		
		Authentication authentication= new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		
		String token = JwtProvider.generateToken(authentication);
		
		AuthResponse response= new AuthResponse(token,"Register Success");
		
		return response;
		
	}
	
	@PostMapping("/signin")
	public AuthResponse signIn(@RequestBody LoginRequest loginRequest) {
		
		Authentication authentication= authenticate(loginRequest.getEmail(), loginRequest.getPassword());
		
String token = JwtProvider.generateToken(authentication);
		
		AuthResponse response= new AuthResponse(token,"Login Success");
		
		return response;
	}

	private Authentication authenticate(String email, String password) {
		
		UserDetails userDetails= customUserDetails.loadUserByUsername(email);
		
		if (userDetails==null) {
			
			throw new BadCredentialsException("invalid username");
		}
		
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			
			throw new BadCredentialsException("password not matched");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
	
	
	
	
	
	
	
}
