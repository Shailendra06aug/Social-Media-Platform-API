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
import com.zosh.exceptions.MessageException;
import com.zosh.model.Message;
import com.zosh.model.User;
import com.zosh.service.ChatService;
import com.zosh.service.MessageService;
import com.zosh.service.UserService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/messages/chat/{chatId}")
	public Message creatMessage(@RequestBody Message req, @RequestHeader("Authorization") String Jwt,@PathVariable Integer chatId) throws MessageException, ChatException {
	
		User user= userService.findUserByJwt(Jwt);
		
		Message msg= messageService.createMessage(req, chatId, user);
		
		return msg;
	}
	
	@GetMapping("/api/messages/chat/{chatId}")
	public List<Message> findChatMessage(@PathVariable Integer chatId) throws MessageException, ChatException{
		
		return messageService.findChatmessages(chatId);
	}
	
	@GetMapping("/api/messages/chat")
	public List<Message> findAllMsgs(){
		
		List<Message> msg = messageService.findAllMessgages();
		
		return msg;
	}
	
	
}
