package com.elitech.gcandidate.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.entities.Notification;
import com.elitech.gcandidate.entities.Statut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidatureDto extends BaseDto{

	private LocalDate dateSoumission;
	private Statut statutCandiature;
	private Candidat candidat;
	private List<Notification> notifications = new ArrayList<>();
}
