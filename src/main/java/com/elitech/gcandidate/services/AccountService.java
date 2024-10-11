package com.elitech.gcandidate.services;

import java.util.List;

import com.elitech.gcandidate.entities.AppRole;
import com.elitech.gcandidate.entities.AppUser;


public interface AccountService {

	
	public AppUser saveUser(String username, String password, String confirmPassword, int active);
	public AppRole saveRole(String role);
	public void addRoleToUser(String username,String roleName);
	public void removeRoleFromUser(String username,String roleName);
	public AppUser loadUserByUsername(String username);
	public List<AppUser> getAllUsers();
}
