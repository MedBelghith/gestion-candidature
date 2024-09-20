package com.elitech.gcandidate.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.gcandidate.dtos.CandidatDto;
import com.elitech.gcandidate.entities.Candidat;



public class CandidatMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	public static CandidatDto convertToDTO(Candidat candidat)
	{
	return modelMapper.map(candidat, CandidatDto.class);
	}

	public static Candidat convertToEntity(CandidatDto candidatDto)
	{
	return modelMapper.map(candidatDto, Candidat.class);	
	}
}
