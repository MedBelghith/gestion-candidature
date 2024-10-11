package com.elitech.gcandidate.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.gcandidate.dtos.OffreDto;
import com.elitech.gcandidate.entities.Offre;

public class OffreMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	public static OffreDto convertToDTO(Offre offre)
	{
	return modelMapper.map(offre, OffreDto.class);
	}

	public static Offre convertToEntity(OffreDto offreDto)
	{
	return modelMapper.map(offreDto, Offre.class);	
	}
}
