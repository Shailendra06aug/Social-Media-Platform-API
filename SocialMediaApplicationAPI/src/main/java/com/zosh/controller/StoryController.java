package com.zosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.StoryException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Story;
import com.zosh.model.User;
import com.zosh.service.StoryService;
import com.zosh.service.UserService;

@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/story")
	public Story creatStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt) {
	
		User reqUser= userService.findUserByJwt(jwt);
		
		return storyService.createStory(story, reqUser);
	}
	
	@GetMapping("/api/story/user/{userId}")
	public List<Story> findUserStory(@PathVariable Integer userId, @RequestHeader("Authorization") String jwt) throws StoryException, UserException{
		
		User reqUser= userService.findUserByJwt(jwt);
		
		List<Story> story= storyService.findStoryByUserId(userId);
		
		return story;
	}
	
	
	
	
	
	
	
}
