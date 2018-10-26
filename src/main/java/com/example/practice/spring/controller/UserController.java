package com.example.practice.spring.controller;

import com.example.practice.spring.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
	private List<User> userList = new ArrayList<User>();

	{
		userList.add(new User(1, "test1", "test1@gmail.com", "test1", new Date()));
		userList.add(new User(2, "test2", "test2@gmail.com", "test2", new Date()));
		userList.add(new User(3, "test3", "test3@gmail.com", "test3", new Date()));
		userList.add(new User(4, "test4", "test4@gmail.com", "test4", new Date()));
		userList.add(new User(5, "test5", "test5@gmail.com", "test5", new Date()));
	}

	@GetMapping("/{userNo}")
	public ResponseEntity<User> getUserInfo(@PathVariable int userNo) {
		User user = userList.get(userNo);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<User>> getUserList() {
		Map<String, List<User>> result = new HashMap<String, List<User>>();
		result.put("result" ,userList);
		return new ResponseEntity(result, HttpStatus.OK);
	}
}
