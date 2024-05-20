package com.zosh.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.exceptions.StoryException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Story;
import com.zosh.model.User;
import com.zosh.repository.StoryRepository;
import com.zosh.service.StoryService;
import com.zosh.service.UserService;

@Service
public class StoryServiceImplemention implements StoryService {

	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Story createStory(Story story, User user) {
		
		Story creatStory= new Story();
		creatStory.setCaption(story.getCaption());
		creatStory.setImage(story.getImage());
		creatStory.setTimeStampped(LocalDateTime.now());
		creatStory.setUser(user);
		
		return storyRepository.save(creatStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException {
		User user= userService.findUserById(userId);
		
		return storyRepository.findByUserId(user.getId());
//		return storyRepository.findByUserId(userId);
	}

	
	
}
