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
public class Entretien extends Audit{
	
	private LocalDate dateEntretien;
	@ManyToOne
	private Recruteur recruteur;
	@ManyToOne
	private Candidat candidat;
}
