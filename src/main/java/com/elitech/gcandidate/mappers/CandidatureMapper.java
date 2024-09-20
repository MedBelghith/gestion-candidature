package com.elitech.gcandidate.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.gcandidate.dtos.CandidatureDto;
import com.elitech.gcandidate.entities.Candidature;


public class CandidatureMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	public static CandidatureDto convertToDTO(Candidature candidature)
	{
	return modelMapper.map(candidature, CandidatureDto.class);
	}

	public static Candidature convertToEntity(CandidatureDto candidatureDto)
	{
	return modelMapper.map(candidatureDto, Candidature.class);	
	}
}
