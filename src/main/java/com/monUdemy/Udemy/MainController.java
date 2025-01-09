package com.monUdemy.Udemy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.mongol.model.*;
import com.mongol.repo.*;
import Scheme.*;
import Util.PasswordUtils;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MainController {

		@Autowired
		private AdminRepository adminRepo;
		
		@Autowired
		private CourseRepository courseRepo;
		
		@Autowired
		private LessonRepository lessonRepo;
		
		@Autowired
		private PurchaseRepository purchaseRepo;

		@Autowired
		private UserRepository userRepo;
		
		@GetMapping("/admin")
		public String addAdmin() {
			try {
				Admin admin = new Admin();
//				admin.setName(name);
//				admin.setEmail(email);
				adminRepo.insert(admin);
				return String.format("Succesfully");
			}catch(Exception e) {
				return String.format("Non succus-->" + e.getMessage());
			}
		}

		@GetMapping("/course")
		public String getCourse() {
			try {
				return String.format("Succesfully");
			}catch(Exception e) {
				return String.format("Non succus-->" + e.getMessage());
			}
		}
		
		@PostMapping("/course")
		public ResponseScheme addCourse(@RequestBody CourseScheme scheme) {
			try {
				
				if(scheme.getName() == null)
					throw new Exception("コース名入力してください。");
				
				Course course = new Course();
				course.setName(scheme.getName());
				course.setImgUrl(scheme.getImgUrl());
				course.setPrice(scheme.getPrice());
				course.setRealPrice(scheme.getRealPrice());
				
				List<User> userList = new ArrayList<>();
				userList = userRepo.findAll();
				
				boolean isUserExist = false;
				
				for(User user : userList) {
					if(user.getToken().equals(scheme.getToken()) && scheme.getToken().length() != 0){
						course.setUserid(user.getId());
						isUserExist = true;
						break;
					}
				}
				
				if(isUserExist){
					courseRepo.insert(course);
				}else {
					throw new Exception("ログインする必要がある");
				}
				return ResponseScheme.getInstance(true);
			}catch(Exception e) {
				return ResponseScheme.getInstance(false, e.getMessage());
			}
		}
		
		@GetMapping("/lesson")
		public String getLesson() {
			try {
				Lesson lesson = new Lesson();
				
				lesson.setName("testLesson1234");
				lessonRepo.insert(lesson);
				return String.format("Succesfully");
			}catch(Exception e) {
				return String.format("Non succus-->" + e.getMessage());
			}
		}
		
		@GetMapping("/purchase")
		public String getPurchase() {
			try {
				Purchase purchase = new Purchase();
				
				purchase.setCourseId(999);
				purchaseRepo.insert(purchase);
				return String.format("Succesfully");
			}catch(Exception e) {
				return String.format("Non succus-->" + e.getMessage());
			}
		}
		
//		@GetMapping("/user")
//		public String getUser() {
//			try {
////				User user = new User();
////				
////				user.setEmail("TestUser@user.com");
////				userRepo.insert(user);
//				return String.format("Succesfully");
//			}catch(Exception e) {
//				return String.format("Non succus-->" + e.getMessage());
//			}
//		}
		
		@PostMapping("/user")
		public ResponseScheme addUser(@RequestBody UserScheme scheme) {
			try {
				User user = new User();
				user.setName(scheme.getName());
				user.setEmail(scheme.getEmail());
				
				String salt = PasswordUtils.getSalt(10);
				user.setSalt(salt);
				user.setPass(PasswordUtils.generateSecurePassword(scheme.getPass(),salt));
				
				userRepo.insert(user);
				
				return ResponseScheme.getInstance(true);
			}catch(Exception e) {
				return ResponseScheme.getInstance(false, e.getMessage());
			}
		}
		
		@PostMapping("/userLogin")
		public LoginResponse LoginUser(@RequestBody LoginScheme scheme) {
			try {
				List<User> userList = new ArrayList<>();
				
				userList = userRepo.findAll();
				
				for(User user : userList) {
					if(scheme.getEmail().equals(user.getEmail())) {
						if(PasswordUtils.verifyUserPassword(scheme.getPass(), user.getPass(), user.getSalt())) {
							String salt = PasswordUtils.getSalt(10);
							String token = PasswordUtils.generateSecurePassword(user.getEmail() + user.getPass(), salt);
							user.setToken(token);
							userRepo.save(user);
							return new LoginResponse(token);
						}
					}//04:04
				}
				throw new Exception("メールアドレスが不一致。。。");
			}catch(Exception e) {
				return new LoginResponse(false, e.getMessage());
			}
		}



}
