package com.zosh.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ChatException.class)
	public ResponseEntity<ErrorDetails> chatExceptionHandler(ChatException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CommentsException.class)
	public ResponseEntity<ErrorDetails> commentsExceptionHandler(CommentsException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostException.class)
	public ResponseEntity<ErrorDetails> postExceptionHandler(PostException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MessageException.class)
	public ResponseEntity<ErrorDetails> postExceptionHandler(MessageException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ReelsException.class)
	public ResponseEntity<ErrorDetails> postExceptionHandler(ReelsException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(StoryException.class)
	public ResponseEntity<ErrorDetails> postExceptionHandler(StoryException ue, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(), request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
