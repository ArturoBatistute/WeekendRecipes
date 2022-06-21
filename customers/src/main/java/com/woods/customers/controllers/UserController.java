package com.woods.customers.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woods.customers.entities.Customer;
import com.woods.customers.services.UserService;

@RestController
@RequestMapping(value = "/users")
public final class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{userId}")
	private ResponseEntity<Customer> findUserById(@PathVariable Long userId){

		final Optional<Customer> user = userService.findById(userId);

		return ResponseEntity.of(user);
	}

	@GetMapping
	private ResponseEntity<List<Customer>> findUsers() {

		return ResponseEntity.ok(userService.findUsers());
	}

	@PostMapping
	private ResponseEntity<Customer> createUser(@RequestBody Customer newUser) throws Exception{

		userService.createUser(newUser);

		return ResponseEntity.ok(newUser);
	}
}
