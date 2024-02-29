package com.jsp.agro_3.dao;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.agro_3.entity.User;
import com.jsp.agro_3.repo.UserRepo;



@Repository
public class UserDao {

	@Autowired
	UserRepo repo;
	
	@Autowired
	Addressdao adr;
	
//1	Register User
	public User register(User user) {
		 Optional<User> db = repo.fetchByEmail(user.getEmail());
		if(db.isEmpty()){
//			 adr.saveAddress(user.getAddress());
			return repo.save(user);
			}
		return null;
	}
	
//2	FetchByEmail
	public User login(String email) {
		Optional<User> db = repo.fetchByEmail(email);
		if(db.isPresent())
			return db.get();
		return null;
	}
	
//3	FetchById
	public User fetchById(int id) {
		Optional<User> db = repo.findById(id);
		if(db.isPresent())
			return db.get();
		return null;
	}
	
//4	UpdateById 
	public User updateUser(User user) {
		Optional<User> db = repo.findById(user.getId());
		
		if(db.isPresent())
		{
			User udb = db.get();
			
			if(user.getFirstName()!=null)
				udb.setFirstName(user.getFirstName());
			if(user.getLastName()!=null)
				udb.setLastName(user.getLastName());
			if(user.getEmail()!=null)
				udb.setEmail(user.getEmail());
			if(user.getPhone()!=0)
				udb.setPhone(user.getPhone());
			if(user.getPassword()!=null)
				udb.setPassword(user.getPassword());
			if(user.getAddress()!=null)
				udb.setAddress(user.getAddress());
			if(user.getAge()!=0)
				udb.setAge(user.getAge());
			if(user.getType()!=null)
				udb.setType(user.getType());
			if(user.getGender()!=null)
				udb.setGender(user.getGender());
			
			return repo.save(udb);
		}
		return null;
	}
	
//5	Forgot password: Update Password By Email
	public User modifyUser(String email,String password) {
		Optional<User> db = repo.fetchByEmail(email);
		if(db.isPresent())
		{	User user = db.get();
			user.setPassword(password);
			return repo.save(user);
		}
		return null;
	}
	
//6	DeleteById
	public User deleteUser(int id) {
		Optional<User> db = repo.findById(id);
		if(db.isPresent())
		  {
			repo.deleteById(id);
			return db.get();
			}
		return null;
	}
	
//7	DeleteByEmail
	public User removeUser(String email) {
		Optional<User> db = repo.fetchByEmail(email);
		if(db.isPresent())
			repo.deleteByEmail(email);
		return null;
	}
	
//8	FetchAll
	public List<User> fetchAll() {
		List<User> db = repo.findAll();
		return db; 
	}
	
}