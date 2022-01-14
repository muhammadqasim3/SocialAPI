package com.example.demo.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;

@Service
public class UserService {
	
	User user1 = new User(
			"1", 
			"Jany", 
			"Lawrence",
			new Location("l1", "Lagos"),
			"Jany@gmail.com");		
	User user2 = new User(
		"2", 
		"Jadon", 
		"Mills",
		new Location("l2", "Asaba"),
		"Jadon@gmail.com");

	private List<User> users = Arrays.asList(user1, user2);
	
	// List of all users	
	public List<User> getAllUsers() {
		return users;
	}	
	
	// Get single user
	public User getUser(String id) {
		User user = users.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return user;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void updateUser(User user, String id) {
		for(int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if(u.getId().equals(id)) {
				// i = passed id from @PathVariable
				users.set(i, user);
			}
		}
	}

	public void deleteUser(String id) {
		users.removeIf(t -> t.getId().equals(id));	
	}
}
