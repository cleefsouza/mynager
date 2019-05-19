package com.mynager.rest.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynager.rest.api.model.User;
import com.mynager.rest.api.services.UserService;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

	@Autowired
	private UserService usService;
	
	/*
	 * methods 
	 */
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long id) {
		return usService.findById(id);
	}
	
	/*
	 * crud
	 */
	
	@PostMapping()
	public void save(@Valid @RequestBody User user) {
		usService.save(user);
	}
	
	@PutMapping("/{id}")
	public void update(@Valid @RequestBody User user, @PathVariable("id") long id) {
		user.setId(id);
		usService.update(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		usService.delete(id);
	}
	
	@GetMapping()
	public List<User> findAll(){
		return usService.findAll();
	}
}
