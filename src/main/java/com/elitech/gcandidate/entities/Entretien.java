package com.elitech.gcandidate.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
	private String duration;
	private String title;
	@Lob
	private String description;
	@ManyToOne
	private Recruteur recruteur;
	@ManyToOne
	private Candidat candidat;

	public void planifierEntretien(LocalDate nouvelleDate) {
        this.dateEntretien = nouvelleDate;
    }
	public void annulerEntretien() {
        this.dateEntretien=null;
    }
}
