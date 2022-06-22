package com.woods.customers.entities;

import java.util.LinkedHashSet;
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

	private LinkedHashSet<String> recipesUrl;

	public Customer() {}

	public Customer(Long userId, @NotNull String name, @NotNull String email, @NotNull String password,
			LinkedHashSet<String> recipeUrl) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.recipesUrl = recipeUrl;
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

	public LinkedHashSet<String> getRecipeUrl() {
		return recipesUrl;
	}

	public void setRecipeUrl(LinkedHashSet<String> recipeUrl) {
		this.recipesUrl = recipeUrl;
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, password, recipesUrl, userId);
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
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(recipesUrl, other.recipesUrl)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", recipeUrl=" + recipesUrl + "]";
	}
}
