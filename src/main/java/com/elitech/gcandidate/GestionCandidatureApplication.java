package com.elitech.gcandidate;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elitech.gcandidate.dtos.CandidatDto;
import com.elitech.gcandidate.entities.Candidature;
import com.elitech.gcandidate.entities.Entretien;
import com.elitech.gcandidate.entities.Statut;
import com.elitech.gcandidate.services.CandidatService;

@SpringBootApplication
public class GestionCandidatureApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GestionCandidatureApplication.class, args);
	}

	@Autowired
	CandidatService candidatService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		candidatService.createOneCandidat(new CandidatDto("mon cv", "ma lettre de motivation",Statut.EN_ATTENTE,new ArrayList<Candidature>(),new ArrayList<Entretien>()));
	}

}
