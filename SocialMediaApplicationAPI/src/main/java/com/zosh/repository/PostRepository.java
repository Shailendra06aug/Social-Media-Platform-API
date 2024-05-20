package com.zosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.zosh.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	@Query("Select p from Post p where p.user.id=:userId")
	public List<Post> findPostByUserId(@Param("userId") Integer userId);
	
}
