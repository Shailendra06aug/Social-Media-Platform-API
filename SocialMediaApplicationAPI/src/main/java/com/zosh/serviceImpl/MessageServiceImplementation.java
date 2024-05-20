package com.zosh.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.exceptions.ChatException;
import com.zosh.exceptions.MessageException;
import com.zosh.model.Chat;
import com.zosh.model.Message;
import com.zosh.model.User;
import com.zosh.repository.ChatRepository;
import com.zosh.repository.MessageRepositry;
import com.zosh.service.ChatService;
import com.zosh.service.MessageService;
import com.zosh.service.UserService;


@Service
public class MessageServiceImplementation implements MessageService   {

	@Autowired
	private MessageRepositry messageRepositry;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private ChatService chatService;
	
	@Override
	public Message createMessage(Message req, Integer chatId, User user ) throws MessageException, ChatException {
		
		Chat chat= chatService.findChatById(chatId);
		
		Message message= new Message();
		
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setTimeStamp(LocalDateTime.now());
		message.setUser(user);
		
		Message savedMessage= messageRepositry.save(message);
		chat.getMessages().add(savedMessage);
		
		chatRepository.save(chat);
		
		return savedMessage;
	}

	@Override
	public List<Message> findChatmessages(Integer chatId) throws MessageException, ChatException {
		Chat chat= chatService.findChatById(chatId);
		
		return messageRepositry.findByChatId(chatId);
	}

	@Override
	public List<Message> findAllMessgages() {
		
		List<Message> allmsg= messageRepositry.findAll();
		
		return allmsg;
	}
	
	

	
}
