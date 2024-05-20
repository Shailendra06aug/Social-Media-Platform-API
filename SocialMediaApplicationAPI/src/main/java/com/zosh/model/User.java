package com.zosh.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String fistName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String password;
	private String gender;
	
	private List<Integer> followers=new ArrayList<>();
	private List<Integer> followings = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	private List<Post> savedPost= new ArrayList<>();
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Integer id, String fistName, String lastName, String email, String password, String gender,
			List<Integer> followers, List<Integer> followings, List<Post> savedPost) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.followers = followers;
		this.followings = followings;
		this.savedPost = savedPost;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFistName() {
		return fistName;
	}



	public void setFistName(String fistName) {
		this.fistName = fistName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public List<Integer> getFollowers() {
		return followers;
	}



	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}



	public List<Integer> getFollowings() {
		return followings;
	}



	public void setFollowings(List<Integer> followings) {
		this.followings = followings;
	}



	public List<Post> getSavedPost() {
		return savedPost;
	}



	public void setSavedPost(List<Post> savedPost) {
		this.savedPost = savedPost;
	}







	

	
	
	
	
}
