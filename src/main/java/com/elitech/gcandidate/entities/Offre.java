package com.elitech.gcandidate.entities;

import java.time.LocalDate;

import jakarta.persistence.Lob;

public class Offre extends Audit{


    private String titre; 
    @Lob
    private String description; 
    private String typeContrat; 

    private double salaire; 

    private String niveauExperience; 

    private String niveauEtude; 
    private String competencesRequises; 

    private LocalDate dateExpiration; // Date limite pour postuler
	
}
