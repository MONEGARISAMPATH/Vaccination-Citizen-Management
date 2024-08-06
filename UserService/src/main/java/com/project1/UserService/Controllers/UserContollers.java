package com.project1.UserService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project1.UserService.Entity.AddResponse;
import com.project1.UserService.Entity.User;
import com.project1.UserService.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserContollers {
	
	@Autowired
	UserService user;
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		 return user.getAllUsers();
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable int id) {
	return	user.getbyId(id);
	}
	@GetMapping("/userName")
	public ResponseEntity<List<User>> getUserByName(@RequestParam User name){
	return 	user.getUserByName(name);	
	}
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User use) {
	return user.createUser(use);
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser( @PathVariable(value="id") int id,@RequestBody User use) {
		 user.getbyId(id);
		 return user.updateUser(use);
	}
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<AddResponse>deleteUser(@PathVariable int id) {
		return user.deleteUser(id);
	}

}
