package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.ReelsException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Reels;
import com.zosh.model.User;

public interface ReelsService {

	public Reels createReels(Reels reels, User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUserReels(Integer userId) throws ReelsException, UserException;
}
