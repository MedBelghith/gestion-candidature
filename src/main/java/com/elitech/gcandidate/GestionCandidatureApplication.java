package com.elitech.gcandidate;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.elitech.gcandidate.dtos.CandidatDto;
import com.elitech.gcandidate.entities.Candidature;
import com.elitech.gcandidate.entities.Entretien;
import com.elitech.gcandidate.entities.Statut;
import com.elitech.gcandidate.services.AccountService;
import com.elitech.gcandidate.services.CandidatService;

@SpringBootApplication
public class GestionCandidatureApplication implements CommandLineRunner{
	@Autowired
	CandidatService candidatService;
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionCandidatureApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE(){
	return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.saveUser("admin", "1234","1234",1);
		accountService.saveUser("user", "1234","1234",1);
		accountService.saveRole("ADMIN");
		accountService.saveRole("USER");
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user","USER");
		
		candidatService.createOneCandidat(new CandidatDto("mon cv", "ma lettre de motivation",Statut.EN_ATTENTE,new ArrayList<Candidature>(),new ArrayList<Entretien>()));
	}

}
