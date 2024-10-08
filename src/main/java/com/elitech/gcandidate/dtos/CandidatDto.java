package com.elitech.gcandidate.dtos;

import java.util.ArrayList;
import java.util.List;

import com.elitech.gcandidate.entities.Candidature;
import com.elitech.gcandidate.entities.Entretien;
import com.elitech.gcandidate.entities.Statut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatDto extends UtilisateurDto{
	
	private String cv;
	private String lettreMotivation;
	private Statut statutCandidature;
	private List<Candidature> candidatures = new ArrayList<>();
	private List<Entretien> entretiens = new ArrayList<>();
}
