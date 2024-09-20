package com.elitech.gcandidate.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.gcandidate.dtos.RecruteurDto;

public interface RecruteurService {

	public RecruteurDto createOneRecruteur (RecruteurDto recruteurDto);
	public RecruteurDto getOneRecruteur (long id);
	public Page<RecruteurDto> getAllRecruteur (Pageable pageable);
	public void deleteOneRecruteur(long id);
}
