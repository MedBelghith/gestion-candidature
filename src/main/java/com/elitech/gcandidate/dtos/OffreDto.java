package com.elitech.gcandidate.dtos;

import java.time.LocalDate;



public class OffreDto extends BaseDto{

	private String titre; 
    private String description; 
    private String typeContrat; 

    private double salaire; 

    private String niveauExperience; 

    private String niveauEtude; 
    private String competencesRequises; 

    private LocalDate dateExpiration;
}
