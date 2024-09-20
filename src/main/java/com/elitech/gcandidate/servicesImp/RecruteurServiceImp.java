package com.elitech.gcandidate.servicesImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.dtos.RecruteurDto;
import com.elitech.gcandidate.entities.Recruteur;
import com.elitech.gcandidate.mappers.RecruteurMapper;
import com.elitech.gcandidate.repositories.EntretienRepository;
import com.elitech.gcandidate.repositories.RecruteurRepository;
import com.elitech.gcandidate.services.RecruteurService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class RecruteurServiceImp implements RecruteurService{

	RecruteurRepository recruteurRepository;
	@Override
	public RecruteurDto createOneRecruteur(RecruteurDto recruteurDto) {
		Recruteur recruteur = RecruteurMapper.convertToEntity(recruteurDto);
		return RecruteurMapper.convertToDTO(recruteurRepository.save(recruteur));
	}

	@Override
	public Page<RecruteurDto> getAllRecruteur(Pageable pageable) {
		Page<Recruteur> recruteurs = recruteurRepository.findAll(pageable);

		return recruteurs.map(RecruteurMapper::convertToDTO);
	}

	@Override
	public void deleteOneRecruteur(long id) {
		if (recruteurRepository.findById(id)!=null)
		recruteurRepository.deleteById(id);
			else throw new RuntimeException("error deleting recruteur");
	}

	@Override
	public RecruteurDto getOneRecruteur(long id) {
		Recruteur recruteur = recruteurRepository.findById(id).orElseThrow(()->new RuntimeException("recruteur "+ id +" does not exist"));
		return RecruteurMapper.convertToDTO(recruteur);
	}
}
