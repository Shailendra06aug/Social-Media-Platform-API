package com.zosh.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.Mapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String chat_name;
	
	private String chat_image;
	
	private LocalDateTime timeStamp;
	
	@ManyToMany
	private List<User> users= new  ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "chat")
	private List<Message> messages= new ArrayList<>();

	
	
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Chat(Integer id, String chat_name, String chat_image, LocalDateTime timeStamp, List<User> users,
			List<Message> messages) {
		super();
		this.id = id;
		this.chat_name = chat_name;
		this.chat_image = chat_image;
		this.timeStamp = timeStamp;
		this.users = users;
		this.messages = messages;
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getChat_name() {
		return chat_name;
	}



	public void setChat_name(String chat_name) {
		this.chat_name = chat_name;
	}



	public String getChat_image() {
		return chat_image;
	}



	public void setChat_image(String chat_image) {
		this.chat_image = chat_image;
	}



	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	
	
	
	
}
