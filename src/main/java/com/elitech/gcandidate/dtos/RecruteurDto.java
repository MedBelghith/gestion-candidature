package com.elitech.gcandidate.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.entities.Entretien;
import com.elitech.gcandidate.entities.Recruteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RecruteurDto extends UtilisateurDto{

	private String privileges;

	private List<Entretien> entretiens = new ArrayList<>();
}
