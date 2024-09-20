package com.elitech.gcandidate.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.gcandidate.dtos.EntretienDto;


public interface EntretienService {

	public EntretienDto createOneEntretien (EntretienDto entretienDto);
	public EntretienDto getOneEntretien (long id);
	public Page<EntretienDto> getAllEntretien (Pageable pageable);
	public void deleteOneEntretien(long id);
}
