package com.mongol.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	@Id
	private Long id;
	private String name, email, pass, token, salt;
	private Integer isTeacher;
	
	public User() {
		this("", "", "", "", 0);
	}

	public User(String name, String email, String pass, String token, Integer isTeacher) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		
		this.id = Long.parseLong(datetime);
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.token = token;
		this.isTeacher = isTeacher;
	}

	
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getIsTeacher() {
		return isTeacher;
	}

	public void setIsTeacher(Integer isTeacher) {
		this.isTeacher = isTeacher;
	}
	
	
	
	

}
