package com.elitech.gcandidate.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidature extends Audit{

	private LocalDate dateSoumission;
	private Statut statutCandiature;
	@ManyToOne
	private Candidat candidat;
}
