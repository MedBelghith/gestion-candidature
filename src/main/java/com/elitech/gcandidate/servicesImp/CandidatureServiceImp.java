package com.elitech.gcandidate.servicesImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.dtos.CandidatureDto;
import com.elitech.gcandidate.entities.Candidature;
import com.elitech.gcandidate.mappers.CandidatureMapper;
import com.elitech.gcandidate.repositories.CandidatureRepository;
import com.elitech.gcandidate.services.CandidatureService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidatureServiceImp implements CandidatureService{

	CandidatureRepository candidatureRepository;
	@Override
	public CandidatureDto createOneCandidature(CandidatureDto candidatureDto) {
		Candidature candidature = CandidatureMapper.convertToEntity(candidatureDto);
		return CandidatureMapper.convertToDTO(candidatureRepository.save(candidature));
	}

	@Override
	public Page<CandidatureDto> getAllCandidature(Pageable pageable) {
		Page<Candidature> candidatures = candidatureRepository.findAll(pageable);

		return candidatures.map(CandidatureMapper::convertToDTO);
	}

	@Override
	public void deleteOneCandidature(long id) {
		if (candidatureRepository.findById(id)!=null)
		candidatureRepository.deleteById(id);
			else throw new RuntimeException("error deleting candidature");
	}

	@Override
	public CandidatureDto getOneCandidature(long id) {
		Candidature candidature = candidatureRepository.findById(id).orElseThrow(()->new RuntimeException("candidature "+ id +" does not exist"));
		return CandidatureMapper.convertToDTO(candidature);
	}
}
