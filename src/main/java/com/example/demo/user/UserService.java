package com.example.demo.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.location.Location;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}	
	
	// Get single user
	public Optional<User> getUser(String id) {
//		CODE WITHOUT JPA REPOSITORY
//		User user = users.stream()
//				.filter(t -> id.equals(t.getId()))
//				.findFirst()
//				.orElse(null);
//		return user;
//		WITH JPA REPOSITORY
		return userRepository.findById(id);
	}

	public void addUser(User user) {
//		users.add(user);
		userRepository.save(user);
	}

	public void updateUser(User user, String id) {
//		for(int i = 0; i < users.size(); i++) {
//			User u = users.get(i);
//			if(u.getId().equals(id)) {
//				// i = passed id from @PathVariable
//				users.set(i, user);
//			}
//		}
		
		userRepository.save(user);
	}

	public void deleteUser(String id) {
//		users.removeIf(t -> t.getId().equals(id));	
		userRepository.deleteById(id);
	}
	public List<User> getUsersByLocation(String id) {
		List<User> users = new ArrayList<>();
		
		userRepository.findByLocationId(id)
		.forEach(users::add);
		
		return users;
	}
	
	
}
