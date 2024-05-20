package com.zosh.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private	Integer id;
	
	private String caption;
	
	private String image;
	
	private LocalDateTime timeStampped;
	
	@ManyToOne
	private User user;

	
	
	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Story(Integer id, String caption, String image, LocalDateTime timeStampped, User user) {
		super();
		this.id = id;
		this.caption = caption;
		this.image = image;
		this.timeStampped = timeStampped;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getTimeStampped() {
		return timeStampped;
	}

	public void setTimeStampped(LocalDateTime timeStampped) {
		this.timeStampped = timeStampped;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
