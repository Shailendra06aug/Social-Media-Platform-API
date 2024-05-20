# Social-Media-Platform-API
Project Description: Social Media Platform REST API
# Overview
The goal of this project is to develop a RESTful API for a social media platform using Spring Boot. The API will support typical social media functionalities such as user registration, profile management, post creation, commenting, liking, and following/unfollowing users. The platform will also include features for authentication, authorization, and activity feeds.

# Key Features
  User Management

   User Registration: Allow users to sign up with a username, email, and password.
   User Login: Authenticate users with JWT-based tokens.
   User Profile: CRUD operations on user profiles (name, bio, profile picture).
   Follow/Unfollow: Users can follow or unfollow other users.
   Posts

   Create Post: Users can create posts with text and media (images/videos).
   Update/Delete Post: Users can edit or delete their posts.
   Get Posts: Fetch posts by user or as part of an activity feed.
   Comments

   Create Comment: Users can comment on posts.
   Update/Delete Comment: Users can edit or delete their comments.
   Likes

    Like/Unlike Post: Users can like or unlike posts.
    Activity Feed

   User Feed: Users can see posts from the users they follow.
   Global Feed: Users can see the most recent posts from all users.
   Authentication & Authorization

JWT Authentication: Secure endpoints using JWT tokens.
Role-Based Access Control: Ensure proper access to endpoints (e.g., only post owners can delete posts).
Technology Stack

Backend: Spring Boot

Database: MySQL or PostgreSQL

Security: Spring Security with JWT

ORM: Hibernate

In-Memory Database: H2 (for testing)

Build Tool: Maven
