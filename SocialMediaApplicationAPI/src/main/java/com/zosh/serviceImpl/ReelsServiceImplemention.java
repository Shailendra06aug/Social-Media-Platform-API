package com.zosh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.exceptions.ReelsException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Reels;
import com.zosh.model.User;
import com.zosh.repository.ReelsRepository;
import com.zosh.service.ReelsService;
import com.zosh.service.UserService;

@Service
public class ReelsServiceImplemention implements ReelsService {

	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Reels createReels(Reels reels, User user) {
		Reels sReels = new Reels();
		
		sReels.setTitle(reels.getTitle());
		sReels.setVideo(reels.getVideo());
		sReels.setUser(user);
		
		return reelsRepository.save(sReels);
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUserReels(Integer userId) throws ReelsException, UserException {
		User user=userService.findUserById(userId);
		
		return reelsRepository.findByUserId(user.getId());
//		return reelsRepository.findByUserId(userId);
	}

	
}
