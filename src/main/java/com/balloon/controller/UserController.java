package com.balloon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.Enums.Status;
import com.balloon.Exception.ResourceNotFoundException;
import com.balloon.model.User;
import com.balloon.repository.UserRepo;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepo userRepository;

	// get all users
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();

	}
	
	
	// Add User
		@PostMapping("/users")
		public User addUser(@RequestBody User user) {
			 return userRepository.save(user);

		}
		
	// get User by id
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUser(@PathVariable Long id) {
			 User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user found for id: "+ id));
			 return ResponseEntity.ok(user);
		}
		
	// update User details
		@PutMapping("/users/{id}")
		public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
			 User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user found for id: "+ id));
			 user.setName(userDetails.getName());
			 user.setUsername(userDetails.getUsername());
			 user.setAddress(userDetails.getAddress());
			 user.setCity(userDetails.getCity());
			 user.setMobile(userDetails.getMobile());
			 user.setEmail(userDetails.getEmail());
			 user.setPincode(userDetails.getPincode());
			 user.setStatus(Status.ACTIVE);
			 
			 userRepository.save(user);
			 return ResponseEntity.ok(user);
		}
		
	// delete User details
		@DeleteMapping("users/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
			 User user = userRepository.findById(id)
					 .orElseThrow(() -> new ResourceNotFoundException("No user found for id: "+ id));
			 userRepository.delete(user);
			 Map<String, Boolean> response = new HashMap<>();
			 response.put("deleted", Boolean.TRUE);
			 return ResponseEntity.ok(response);
		}
	

}
