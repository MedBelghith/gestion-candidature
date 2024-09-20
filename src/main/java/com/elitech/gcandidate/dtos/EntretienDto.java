package com.elitech.gcandidate.dtos;

import java.time.LocalDate;

import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.entities.Recruteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntretienDto extends BaseDto {

	private LocalDate dateEntretien;
	private Recruteur recruteur;
	private Candidat candidat;
}
