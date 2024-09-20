package com.elitech.gcandidate.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Notification> notifications = new ArrayList<>();
}
