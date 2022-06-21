package com.woods.customers.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woods.customers.entities.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);
}
