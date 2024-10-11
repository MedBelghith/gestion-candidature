package com.elitech.gcandidate.servicesImp;

import java.util.Arrays;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.entities.AppUser;
import com.elitech.gcandidate.services.AccountService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser appuser=accountService.loadUserByUsername(username);
		if(appuser==null) throw new UsernameNotFoundException(String.format("User %s not found", username));
		String[] roles=appuser.getRoles().stream().map(u->  u.getRoleName()).toArray(String[]::new);
		// System.out.println("Loaded roles for user " + username + ": " + Arrays.toString(roles));  // Logging
		UserDetails userDetails= User.withUsername(appuser.getUsername())
				.password(appuser.getPassword())
				.roles(roles)
				.build();
		return userDetails;
	}

}
