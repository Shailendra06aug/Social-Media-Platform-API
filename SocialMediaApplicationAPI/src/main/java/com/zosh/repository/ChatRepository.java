package com.zosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zosh.model.Chat;
import com.zosh.model.User;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
	
    @Query("select c from Chat c where :user Member of c.users And :reqUser Member of c.users")
	public Chat findChatByUsersId(@Param("reqUser") User reqUser, @Param("user") User user2);
	
	public List<Chat> findByUsersId(Integer userId);
}
