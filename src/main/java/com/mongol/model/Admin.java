package com.mongol.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
import java.text.*;

@Document(collection="admin")
public class Admin {
	
	@Id
	private Long id;
	private String name, email, pass, token;

	public Admin() {
		this("","","","");
	}

	public Admin(String name, String email, String pass, String token) {
		
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		
		this.id = Long.parseLong(datetime);
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.token = token;
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


}
