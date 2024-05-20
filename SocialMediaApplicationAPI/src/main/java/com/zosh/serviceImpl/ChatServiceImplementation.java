package com.zosh.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.exceptions.ChatException;
import com.zosh.model.Chat;
import com.zosh.model.User;
import com.zosh.repository.ChatRepository;
import com.zosh.service.ChatService;
import com.zosh.service.UserService;

@Service
public class ChatServiceImplementation implements ChatService {

	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Chat createChat(User reqUser, User user2) throws ChatException {
		
		Chat isExitUser= chatRepository.findChatByUsersId(reqUser, user2);
		
		if (isExitUser!=null) {
			return isExitUser;
		}
		
		Chat chat= new Chat();
		chat.getUsers().add(user2);
		chat.getUsers().add(reqUser);
		chat.setTimeStamp(LocalDateTime.now());
		
		return chatRepository.save(chat);
	}
	
	@Override
	public Chat findChatById(Integer chatId) throws ChatException {
		Optional<Chat> opt= chatRepository.findById(chatId);
		
		if (opt.isEmpty()) {
			throw new ChatException("chat not found with id "+chatId);
		}
		
		return opt.get();
	}
	
	
	@Override
	public List<Chat> findUserChat(Integer userId) {
		
		List<Chat> chats= chatRepository.findByUsersId(userId);
		
		return chats;
	}

	@Override
	public List<Chat> findAllChat() {
		
		return chatRepository.findAll();
	}

	

	

}



