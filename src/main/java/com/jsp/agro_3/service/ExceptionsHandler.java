package com.jsp.agro_3.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.agro_3.exception.EmailExistsException;
import com.jsp.agro_3.exception.PasswordIncorrectException;
import com.jsp.agro_3.exception.UserNotFoundException;
import com.jsp.agro_3.util.ResponseStructure;

@RestControllerAdvice
	
	public class ExceptionsHandler {
		
		@ExceptionHandler(EmailExistsException.class)
		public ResponseEntity<ResponseStructure<String>> emailExists(EmailExistsException e){
			ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatus(HttpStatus.BAD_REQUEST.value());
			rs.setMsg("Email Already Exists");
			rs.setData(e.getMsg());
			
			return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> userNotFound(UserNotFoundException e){
			ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatus(HttpStatus.NOT_FOUND.value());
			rs.setMsg("User doesn't Exists");
			rs.setData(e.getMsg());
			
			return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler(PasswordIncorrectException.class)
		public ResponseEntity<ResponseStructure<String>> invalidPassword(PasswordIncorrectException e){
			ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatus(HttpStatus.BAD_REQUEST.value());
			rs.setMsg("Invalid Password");
			rs.setData(e.getMsg());
			
			return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
		public ResponseEntity<ResponseStructure<String>> sQLIntegrity(PasswordIncorrectException e){
			
			ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatus(HttpStatus.BAD_REQUEST.value());
			rs.setMsg("SqL I");
			rs.setData(e.getMsg());
			
			return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
		}
		
		

	
}
