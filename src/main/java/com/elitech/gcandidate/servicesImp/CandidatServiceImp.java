package com.elitech.gcandidate.servicesImp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.dtos.CandidatDto;
import com.elitech.gcandidate.entities.Candidat;
import com.elitech.gcandidate.mappers.CandidatMapper;
import com.elitech.gcandidate.repositories.CandidatRepository;
import com.elitech.gcandidate.services.CandidatService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CandidatServiceImp implements CandidatService{

	CandidatRepository candidatRepository;
	@Override
	public CandidatDto createOneCandidat(CandidatDto candidatDto) {
		Candidat candidat = CandidatMapper.convertToEntity(candidatDto);
		return CandidatMapper.convertToDTO(candidatRepository.save(candidat));
	}

	@Override
	public Page<CandidatDto> getAllCandidat(Pageable pageable) {
		Page<Candidat> candidats = candidatRepository.findAll(pageable);

		return candidats.map(CandidatMapper::convertToDTO);
	}

	@Override
	public void deleteOneCandidat(long id) {
		if (candidatRepository.findById(id)!=null)
		candidatRepository.deleteById(id);
			else throw new RuntimeException("error deleting candidat");
	}

	@Override
	public CandidatDto getOneCandidat(long id) {
		Candidat candidat = candidatRepository.findById(id).orElseThrow(()->new RuntimeException("cnadidat not exist"));
		return CandidatMapper.convertToDTO(candidat);
	}

}
