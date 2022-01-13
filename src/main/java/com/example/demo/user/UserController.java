package com.example.demo.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location.Location;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> index() {
		return userService.getAllUsers();
	}

	@GetMapping("users/{id}")
	public User getUser(@PathVariable String id) {
		System.out.println("hellp" + id);
		return userService.getUser(id);
	}

	@PostMapping("users")
	public void addUser(User user) {
		userService.addUser(user);
	}
}
