package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.StoryException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Story;
import com.zosh.model.User;

public interface StoryService {

	public Story createStory(Story story, User user);
	
	public List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException;
}
