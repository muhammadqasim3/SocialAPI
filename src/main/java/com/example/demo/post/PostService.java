package com.example.demo.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.location.Location;
import com.example.demo.user.User;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
//	User user1 = new User(
//			"u1", 
//			"Jany", 
//			"Lawrence",
//			new Location("l1", "Lagos"),
//			"Jany@gmail.com");
//			
//		User user2 = new User(
//			"u2", 
//			"Jadon", 
//			"Mills",
//			new Location("l2", "Asaba"),
//			"Jadon@gmail.com");
//			
//		Post post1 = new Post(
//			"1",
//			"01-Jan-19",
//			user1,
//		        "Its good to love and be loved");
//			
//		Post post2 = new Post(
//			"2",
//		        "02-Jan-19",
//			user2,
//			"We all need someone");		
			
//		private List<Post> posts = Arrays.asList(post1, post2);
//		private List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));
		
		public List<Post> getAllPosts(){
//			return posts;
			List<Post> posts = new ArrayList<>();
			
			postRepository.findAll()
			.forEach(posts::add);
			return posts;
		}
		
		public Optional<Post> getPost(String id) {
//			Post post = posts.stream()
//						.filter(t -> id.equals(t.getId()))
//						.findFirst()
//						.orElse(null);
//			return post;
			return postRepository.findById(id);
		}

		public void addPost(Post post) {
//			posts.add(post);
			postRepository.save(post);
		}

		public void updatePost(Post post, String id) {
			// Iteration on posts list to find out the requested resource before modification
//			for(int i = 0; i < posts.size(); i++) {
//				Post p = posts.get(i);
//				if(p.getId().equals(id)) {
//					// i = passed id from @PathVariable
//					posts.set(i, post);
//				}
//			}
			postRepository.save(post);
		}

		public void deletePost(String id) {
//			posts.removeIf(post -> post.getId().equals(id));
			postRepository.deleteById(id);
		}
		
		public List<Post> getPostByUser(String id) {
			List<Post> posts = new ArrayList<>();
			
			postRepository.findByUserId(id)
			.forEach(posts::add);
			 
			return posts;
		}
		
}
