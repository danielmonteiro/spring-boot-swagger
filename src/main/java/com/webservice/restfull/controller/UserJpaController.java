package com.webservice.restfull.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.restfull.exceptions.UserNotFoundException;
import com.webservice.restfull.model.Post;
import com.webservice.restfull.model.User;
import com.webservice.restfull.repository.PostRepository;
import com.webservice.restfull.repository.UserRepository;
import com.webservice.restfull.service.UserDaoService;

@RestController
public class UserJpaController {

	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> findOne(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) throw new UserNotFoundException("id: " + id);
		
		Resource<User> resource = new Resource<User>(user.get());
		
		// HATEOAS
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getPosts(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) throw new UserNotFoundException("id: " + id);
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) throw new UserNotFoundException("id: " + id);
		
		post.setUser(userOptional.get());
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(post.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
