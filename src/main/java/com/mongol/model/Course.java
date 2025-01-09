package com.mongol.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="course")
public class Course {
	
	@Id
	private Long id;
	private String name, imgUrl;
	private Integer price, realPrice;
	private Long userid;
	private LocalDate createdDate;
	

	public Course() {
		this("", "", 0, 0, (long) 0, LocalDate.now());
	}

	public Course(String name, String imgUrl, Integer price, Integer realPrice, Long userid,
			LocalDate createdDate) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		
		this.id = Long.parseLong(datetime);
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		this.realPrice = realPrice;
		this.userid = userid;
		this.createdDate = createdDate;
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


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getRealPrice() {
		return realPrice;
	}


	public void setRealPrice(Integer realPrice) {
		this.realPrice = realPrice;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
