package com.elitech.gcandidate.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class AppUser extends Audit{

	
	
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(unique = true)
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private int active;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList<>();
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
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	
	
}
