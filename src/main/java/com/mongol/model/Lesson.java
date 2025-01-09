package com.mongol.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="lesson")
public class Lesson {
	
	@Id
	private Long id;
	private String name, videoUrl, time;
	private Integer isFree, courseId;
	

	public Lesson() {
		this("","","", 0, 0);
	}


	public Lesson(String name, String videoUrl, String time, Integer isFree, Integer courseId) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		
		this.id = Long.parseLong(datetime);
		this.name = name;
		this.videoUrl = videoUrl;
		this.time = time;
		this.isFree = isFree;
		this.courseId = courseId;
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


	public String getVideoUrl() {
		return videoUrl;
	}


	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public Integer getIsFree() {
		return isFree;
	}


	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	
	
	

}
