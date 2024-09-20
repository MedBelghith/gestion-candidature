package com.elitech.gcandidate.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.gcandidate.dtos.EntretienDto;
import com.elitech.gcandidate.entities.Entretien;

public class EntretienMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	public static EntretienDto convertToDTO(Entretien entretien)
	{
	return modelMapper.map(entretien, EntretienDto.class);
	}

	public static Entretien convertToEntity(EntretienDto entretienDto)
	{
	return modelMapper.map(entretienDto, Entretien.class);	
	}
}
