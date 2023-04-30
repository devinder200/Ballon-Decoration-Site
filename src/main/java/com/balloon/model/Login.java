package com.balloon.model;

import com.balloon.Enums.Role;
import com.balloon.Enums.Status;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class Login {

	@Id
	@Column(name="username")
	private String username;
	
	@Nonnull
	@Column(name="password")
	private String password;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	

	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;

	public Login() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", status=" + status + ", role=" + role + "]";
	}



	
	
	
	
	
}
