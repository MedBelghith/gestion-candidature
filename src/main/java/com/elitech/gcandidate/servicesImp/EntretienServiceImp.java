package com.elitech.gcandidate.servicesImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.dtos.EntretienDto;
import com.elitech.gcandidate.entities.Entretien;
import com.elitech.gcandidate.mappers.EntretienMapper;
import com.elitech.gcandidate.repositories.EntretienRepository;
import com.elitech.gcandidate.services.EntretienService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EntretienServiceImp implements EntretienService{

	EntretienRepository entretienRepository;
	@Override
	public EntretienDto createOneEntretien(EntretienDto entretienDto) {
		Entretien entretien = EntretienMapper.convertToEntity(entretienDto);
		return EntretienMapper.convertToDTO(entretienRepository.save(entretien));
	}

	@Override
	public Page<EntretienDto> getAllEntretien(Pageable pageable) {
		Page<Entretien> entretiens = entretienRepository.findAll(pageable);

		return entretiens.map(EntretienMapper::convertToDTO);
	}

	@Override
	public void deleteOneEntretien(long id) {
		if (entretienRepository.findById(id)!=null)
		entretienRepository.deleteById(id);
			else throw new RuntimeException("error deleting entretien");
	}

	@Override
	public EntretienDto getOneEntretien(long id) {
		Entretien entretien = entretienRepository.findById(id).orElseThrow(()->new RuntimeException("entretien "+ id +" does not exist"));
		return EntretienMapper.convertToDTO(entretien);
	}
}