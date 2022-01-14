package com.example.demo.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location.Location;
import com.example.demo.user.User;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("posts")
	public List<Post> index() {
		return postService.getAllPosts();
	}
	
	@GetMapping("posts/{id}")
	public Post getPost(@PathVariable String id) {
		return postService.getPost(id);
	}
	
	@PostMapping("posts")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@PutMapping("posts/{id}")
	public void updatePost(@RequestBody Post post, @PathVariable String id) {
		postService.updatePost(post, id);
	}
	
	@DeleteMapping("posts/{id}")
	public void deletePost(@PathVariable String id) {
		postService.deletePost(id);
	}
}
