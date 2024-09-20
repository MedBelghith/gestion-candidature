package com.elitech.gcandidate.dtos;

import java.util.ArrayList;
import java.util.List;

import com.elitech.gcandidate.entities.Candidature;
import com.elitech.gcandidate.entities.Entretien;
import com.elitech.gcandidate.entities.Statut;




public class CandidatDto extends BaseDto{

	private String cv;
	private String lettreMotivation;
	private Statut statutCandidature;
	private List<Candidature> candidatures = new ArrayList<>();
	private List<Entretien> entretiens = new ArrayList<>();
}
