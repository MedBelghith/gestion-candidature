package com.elitech.gcandidate.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.gcandidate.dtos.OffreDto;

public interface OffreService {

	public OffreDto createOneOffre (OffreDto offreDto);
	public OffreDto getOneOffre (long id);
	public Page<OffreDto> getAllOffre (Pageable pageable);
	public void deleteOneOffre(long id);
}
