package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.ChatException;
import com.zosh.exceptions.MessageException;
import com.zosh.model.Chat;
import com.zosh.model.Message;
import com.zosh.model.User;

public interface MessageService {

	public Message createMessage(Message req,Integer chatId, User user ) throws MessageException, ChatException;
	
	public List<Message> findChatmessages(Integer chatId) throws MessageException, ChatException;
	
	public List<Message> findAllMessgages();
}
