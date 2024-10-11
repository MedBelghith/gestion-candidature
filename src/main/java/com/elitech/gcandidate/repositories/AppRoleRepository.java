package com.elitech.gcandidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.gcandidate.entities.AppRole;



public interface AppRoleRepository extends JpaRepository<AppRole, String> {
	
	public AppRole findByRoleName(String roleName);

}
