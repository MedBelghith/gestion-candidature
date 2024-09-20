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
public class UtilisateurDto extends BaseDto {

		private String name;
	    private String email;
	    private String roles;
}
