package com.woods.customers.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@NotNull
	private String password;

	public Customer() {}

	public Customer(Long id, String name, String email, String password) {
		super();
		userId = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, email, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Customer other = (Customer) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [Id=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	};
}
