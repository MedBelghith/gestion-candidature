package com.elitech.gcandidate.servicesImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.dtos.OffreDto;
import com.elitech.gcandidate.entities.Offre;
import com.elitech.gcandidate.mappers.OffreMapper;
import com.elitech.gcandidate.repositories.OffreRepository;
import com.elitech.gcandidate.services.OffreService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OffreServiceImp implements OffreService{

	OffreRepository offreRepository;
	@Override
	public OffreDto createOneOffre(OffreDto offreDto) {
		Offre offre = OffreMapper.convertToEntity(offreDto);
		return OffreMapper.convertToDTO(offreRepository.save(offre));
	}

	@Override
	public Page<OffreDto> getAllOffre(Pageable pageable) {
		Page<Offre> offres = offreRepository.findAll(pageable);

		return offres.map(OffreMapper::convertToDTO);
	}

	@Override
	public void deleteOneOffre(long id) {
		if (offreRepository.findById(id)!=null)
		offreRepository.deleteById(id);
			else throw new RuntimeException("error deleting offre");
	}

	@Override
	public OffreDto getOneOffre(long id) {
		Offre offre = offreRepository.findById(id).orElseThrow(()->new RuntimeException("offre "+ id +" does not exist"));
		return OffreMapper.convertToDTO(offre);
	}
}
