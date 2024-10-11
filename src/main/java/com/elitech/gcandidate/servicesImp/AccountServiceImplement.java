package com.elitech.gcandidate.servicesImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elitech.gcandidate.entities.AppRole;
import com.elitech.gcandidate.entities.AppUser;
import com.elitech.gcandidate.repositories.AppRoleRepository;
import com.elitech.gcandidate.repositories.AppUserRepository;
import com.elitech.gcandidate.services.AccountService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImplement implements AccountService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;

    @Override
    public AppUser saveUser(String username, String password, String confirmPassword,int active) {
    	AppUser appuser= appUserRepository.findByUsername(username);
    	if (appuser!=null) throw new RuntimeException("this user %s already exist");
    	if (!password.equals(confirmPassword)) throw new RuntimeException("Passwords not match");
    	String hashPW = bCryptPasswordEncoder.encode(password);
    	appuser= AppUser.builder()
    			.username(username)
    			.password(hashPW)
    			.active(active)
    			.build();
       
    	return appUserRepository.save(appuser);
    }

    @Override
    public AppRole saveRole(String role) {
    	AppRole appRole= appRoleRepository.findById(role).orElse(null);
    	if (appRole!=null) throw new RuntimeException("Role existant");
    	appRole=AppRole.builder().roleName(role).build();
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("this role %s doesn't exist");
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser==null) throw new RuntimeException("this user %s doesn't exist");
        appUser.getRoles().add(appRole);
        //no need to save user because of @Transactional
        //appUserRepository.save(user);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppRole role = appRoleRepository.findByRoleName(roleName);
        AppUser user = appUserRepository.findByUsername(username);
        user.getRoles().remove(role);
    }
}
