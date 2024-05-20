package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.ChatException;
import com.zosh.model.Chat;
import com.zosh.model.User;

public interface ChatService {

	public Chat createChat(User reqUser, User user2) throws ChatException;
	
	public Chat findChatById(Integer chatId) throws ChatException;
	
	public List<Chat> findUserChat(Integer userId);
	
	public List<Chat> findAllChat();
	
	
}
