package com.elitech.gcandidate.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidat extends Utilisateur{

	private String cv;
	private String lettreMotivation;
	@Enumerated
	private Statut statutCandidature;
	@OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Candidature> candidatures = new ArrayList<>();
	@OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Entretien> entretiens = new ArrayList<>();
}
