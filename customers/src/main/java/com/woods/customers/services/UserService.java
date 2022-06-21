package com.woods.customers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woods.customers.entities.Customer;
import com.woods.customers.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<Customer> findUsers() {

		return userRepository.findAll();
	}

	public Optional<Customer> findById(Long userId) {

		return userRepository.findById(userId);
	}

	public void createUser(Customer newUser) throws Exception {

		if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {

			throw new Exception("Customer already exists!");
		}

		userRepository.save(newUser);
	}
}
