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

import com.elitech.gcandidate.dtos.CandidatureDto;
import com.elitech.gcandidate.services.CandidatService;
import com.elitech.gcandidate.services.CandidatureService;

import lombok.AllArgsConstructor;
@RequestMapping("candidature")
@RestController
@AllArgsConstructor
public class CandidatureController {

	CandidatureService candidatureService;
	
	@PostMapping
	public CandidatureDto createOneCandidature(@RequestBody CandidatureDto candidiatDto) {
		return candidatureService.createOneCandidature(candidiatDto);
	}
	@GetMapping
	public ResponseEntity<Page<CandidatureDto>> getAllCandidats(){
		Pageable pageable = PageRequest.of(0, 10);
		return ResponseEntity.ok().body(candidatureService.getAllCandidature(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<CandidatureDto> getOneCandidature(@PathVariable long id){
		return ResponseEntity.ok(candidatureService.getOneCandidature(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneCandidature(@PathVariable long id){
		try {
			candidatureService.deleteOneCandidature(id);
			return ResponseEntity.ok("candiature "+ id +"deleted successfully ");
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error during delete "+ ex.getMessage());
		}
	}
}
