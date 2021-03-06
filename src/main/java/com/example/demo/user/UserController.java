package com.example.demo.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Optional<User> getUser(@PathVariable String id) {
		System.out.println("hellp" + id);
		return userService.getUser(id);
	}

	@PostMapping("users")
	public void addUser(User user) {
		userService.addUser(user);
	}
	
	@PutMapping("users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		userService.updateUser(user, id);
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
}
