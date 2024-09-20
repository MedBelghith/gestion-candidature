package com.elitech.gcandidate.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.entities.Entretien;

public interface EntretienRepository extends JpaRepository<Entretien, Long>{

	Optional<List<Entretien>> findByCandidat(Candidat candidat);
}
