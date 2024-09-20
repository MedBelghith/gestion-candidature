package com.elitech.gcandidate.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.gcandidate.dtos.CandidatureDto;


public interface CandidatureService {

	public CandidatureDto createOneCandidature (CandidatureDto candidatureDto);
	public CandidatureDto getOneCandidature (long id);
	public Page<CandidatureDto> getAllCandidature (Pageable pageable);
	public void deleteOneCandidature(long id);
}
