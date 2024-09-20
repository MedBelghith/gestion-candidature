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

import com.elitech.gcandidate.dtos.CandidatDto;
import com.elitech.gcandidate.services.CandidatService;

import lombok.AllArgsConstructor;

@RequestMapping("candidat")
@RestController
@AllArgsConstructor
public class CandidatController {

	CandidatService candidatService;
	
	@PostMapping
	public CandidatDto createOneCandidat(@RequestBody CandidatDto candidiatDto) {
		return candidatService.createOneCandidat(candidiatDto);
	}
	@GetMapping
	public ResponseEntity<Page<CandidatDto>> getAllCandidats(){
		Pageable pageable = PageRequest.of(0, 10);
		return ResponseEntity.ok().body(candidatService.getAllCandidat(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<CandidatDto> getOneCandidat(@PathVariable long id){
		return ResponseEntity.ok(candidatService.getOneCandidat(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneCandidat(@PathVariable long id){
		try {
			candidatService.deleteOneCandidat(id);
			return ResponseEntity.ok("candiat "+ id +"deleted successfully ");
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error during delete "+ ex.getMessage());
		}
	}
}
