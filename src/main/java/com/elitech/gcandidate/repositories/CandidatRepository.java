package com.elitech.gcandidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.gcandidate.entities.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
