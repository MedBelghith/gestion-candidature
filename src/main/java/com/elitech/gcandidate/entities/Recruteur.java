package com.elitech.gcandidate.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruteur extends Utilisateur {

	private String privileges;
	@OneToMany(mappedBy = "recruteur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Entretien> entretiens = new ArrayList<>();
}
