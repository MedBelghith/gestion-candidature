package com.elitech.gcandidate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.gcandidate.entities.AppRole;
import com.elitech.gcandidate.entities.AppUser;
import com.elitech.gcandidate.services.AccountService;

import lombok.Data;

@RestController
//@RequestMapping("/auth/login")
@CrossOrigin(value = "*")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getAllAccounts()
	{
		return ResponseEntity.ok(accountService.getAllUsers());
	}
//	@GetMapping("/users")
//	public List<AppUser> getAllUsers()
//	{
//		return accountService.getAllUsers();
//		
//	}
	@PostMapping(path="/users")
	public AppUser addOneUSer(@RequestBody String user,@RequestBody String password,@RequestBody String confirmPassword,@RequestBody int active)
	{
		return accountService.saveUser(user, confirmPassword, confirmPassword, active);
		
	}
	@PostMapping(path="/roles")
	public AppRole addOneRole(@RequestBody String role)
	{
		return accountService.saveRole(role);
		
	}
	@PostMapping("/addRoleToUser")
	public void addRoleToUser(@RequestBody RoleUserForm roleUserForm)
	{
		accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRolename());
	}
	
	@Data
	class RoleUserForm{
		private String username;
		private String rolename;
	}
}
