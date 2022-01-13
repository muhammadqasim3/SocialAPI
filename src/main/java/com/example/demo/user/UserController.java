package com.example.demo.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("test")
	public String test() {
		return "HEllo";
	}
}
