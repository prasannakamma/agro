package com.jsp.agro_3.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.agro_3.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select e from User e where email=?1")
	public Optional<User> fetchByEmail(String email);
	
	@Query("delete from User e where email=?1")
	public Optional<User> deleteByEmail(String email);

}
