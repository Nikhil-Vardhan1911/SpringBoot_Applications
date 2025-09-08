package com.cruds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruds.Service.UserService;
import com.cruds.dto.Users;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Users getuserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public String  addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
	@PutMapping("/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable int id) {
		return userService.updateUser(user, id);
	}
}