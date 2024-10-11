package com.elitech.gcandidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.gcandidate.entities.AppUser;



public interface AppUserRepository extends JpaRepository <AppUser,Long>{

	public AppUser findByUsername(String userName);
}
