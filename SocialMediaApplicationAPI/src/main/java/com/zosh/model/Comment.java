package com.zosh.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String content;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<User> liked= new ArrayList<>();

	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer id, String content, LocalDateTime createdAt, User user, List<User> liked) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.user = user;
		this.liked = liked;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public LocalDateTime getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public List<User> getLiked() {
		return liked;
	}




	public void setLiked(List<User> liked) {
		this.liked = liked;
	}

	
	
	
	
	
	
	
}
