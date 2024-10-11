package com.elitech.gcandidate.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.gcandidate.dtos.OffreDto;
import com.elitech.gcandidate.services.OffreService;

import lombok.AllArgsConstructor;

@RequestMapping("offre")
@RestController
@AllArgsConstructor
public class OffreController {

	OffreService offreService;
	
	@PostMapping
	public OffreDto createOneOffre(@RequestBody OffreDto candidiatDto) {
		return offreService.createOneOffre(candidiatDto);
	}
	@GetMapping
	public ResponseEntity<Page<OffreDto>> getAllOffre(){
		Pageable pageable = PageRequest.of(0, 10);
		return ResponseEntity.ok().body(offreService.getAllOffre(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<OffreDto> getOneOffre(@PathVariable long id){
		return ResponseEntity.ok(offreService.getOneOffre(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneOffre(@PathVariable long id){
		try {
			offreService.deleteOneOffre(id);
			return ResponseEntity.ok("candiature "+ id +"deleted successfully ");
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error during delete "+ ex.getMessage());
		}
	}
}
