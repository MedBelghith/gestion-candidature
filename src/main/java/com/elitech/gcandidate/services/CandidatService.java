package com.elitech.gcandidate.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.gcandidate.dtos.CandidatDto;

public interface CandidatService {

	public CandidatDto createOneCandidat (CandidatDto candidatDto);
	public CandidatDto getOneCandidat (long id);
	public Page<CandidatDto> getAllCandidat (Pageable pageable);
	public void deleteOneCandidat(long id);
}
