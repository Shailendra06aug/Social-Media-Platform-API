package com.zosh.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.exceptions.CommentsException;
import com.zosh.exceptions.PostException;
import com.zosh.exceptions.UserException;
import com.zosh.model.Comment;
import com.zosh.model.Post;
import com.zosh.model.User;
import com.zosh.repository.CommentRepository;
import com.zosh.repository.PostRepository;
import com.zosh.repository.UserRepository;
import com.zosh.service.CommentService;
import com.zosh.service.PostService;
import com.zosh.service.UserService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentRepository commentRepository;


	
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentsException,UserException,PostException {
		
	     User user= userService.findUserById(userId);
		
		Post post = postService.findPostById(postId);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		Comment savedComment = commentRepository.save(comment);
		
		post.getComments().add(savedComment);
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer commentId) throws CommentsException {
	
		Optional<Comment> opt= commentRepository.findById(commentId);
		
				if (opt.isEmpty()) {
					throw new CommentsException("Comment not found with id ");
				}
				
				
		return opt.get();
	}

	
	@Override
	public Comment likeComment(Integer commentId, Integer userId) throws CommentsException, UserException {
		
		User user = userService.findUserById(userId);
		
		Comment comment = findCommentById(commentId);
		
		if (!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}
		else
		comment.getLiked().remove(user);
		
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> findAllComment() {
		
		return commentRepository.findAll();
	}

	
	
	
}
