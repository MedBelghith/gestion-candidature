package com.elitech.gcandidate.dtos;

import java.time.LocalDate;

import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.entities.Candidature;
import com.elitech.gcandidate.entities.Recruteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto extends BaseDto{

	private String typeNotification;
	private String destinataire;
	private LocalDate dateEnvoi;

	private Candidature candidature;
}
