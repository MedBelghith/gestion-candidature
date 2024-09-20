package com.elitech.gcandidate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.entities.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long>{

	public List<Candidature> findByCandidat(Candidat candidat);
}
