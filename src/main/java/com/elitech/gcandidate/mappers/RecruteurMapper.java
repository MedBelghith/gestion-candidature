package com.elitech.gcandidate.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.gcandidate.dtos.RecruteurDto;
import com.elitech.gcandidate.entities.Recruteur;

public class RecruteurMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	public static RecruteurDto convertToDTO(Recruteur recruteur)
	{
	return modelMapper.map(recruteur, RecruteurDto.class);
	}

	public static Recruteur convertToEntity(RecruteurDto recruteurDto)
	{
	return modelMapper.map(recruteurDto, Recruteur.class);	
	}
}
