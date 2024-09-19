package com.elitech.gcandidate.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends Audit{

	private String typeNotification;
	private String destinataire;
	private LocalDate dateEnvoi;
}
