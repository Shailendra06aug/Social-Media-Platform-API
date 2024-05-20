package com.zosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.ChatException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Chat;
import com.zosh.model.User;
import com.zosh.request.CreateChatRequest;
import com.zosh.service.ChatService;
import com.zosh.service.UserService;

@RestController
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/chats")
	public Chat creatChat(@RequestHeader("Authorization") String jwt, @RequestBody CreateChatRequest chatRequest) throws ChatException, UserException {
		
		User reqUser= userService.findUserByJwt(jwt);
		
		User user2= userService.findUserById(chatRequest.getUserId());
		
		Chat chat = chatService.createChat(reqUser, user2);
		
		return chat;
	}

	
	@GetMapping("/api/chats")
	public List<Chat> findUsersChat(@RequestHeader("Authorization") String jwt){
		
		User reqUser= userService.findUserByJwt(jwt);
		
		List<Chat> chat= chatService.findUserChat(reqUser.getId());
		
		return chat;
	}
	
	@GetMapping("/api/chats/{chatId}")
	public Chat findChatById(@PathVariable Integer chatId) throws ChatException {
		
		Chat chat= chatService.findChatById(chatId);
		
		return chat;
	}
	
	
	
	
	
}
