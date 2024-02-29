package com.jsp.agro_3.entity;

import com.jsp.agro_3.enums.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String firstName;
   private String lastName;
   @Column(unique = true)
   private String email;
   private long phone;
   private String password;
   private String gender;
   private int age;
   private UserType type;
   @OneToOne(cascade = CascadeType.ALL)
   private Address address;



}
