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

import com.elitech.gcandidate.dtos.RecruteurDto;
import com.elitech.gcandidate.services.RecruteurService;

import lombok.AllArgsConstructor;
@RequestMapping("recruteur")
@RestController
@AllArgsConstructor
public class RecruteurController {

	RecruteurService recruteurService;
	
	@PostMapping
	public RecruteurDto createOneRecruteur(@RequestBody RecruteurDto candidiatDto) {
		return recruteurService.createOneRecruteur(candidiatDto);
	}
	@GetMapping
	public ResponseEntity<Page<RecruteurDto>> getAllRecruteur(){
		Pageable pageable = PageRequest.of(0, 10);
		return ResponseEntity.ok().body(recruteurService.getAllRecruteur(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<RecruteurDto> getOneRecruteur(@PathVariable long id){
		return ResponseEntity.ok(recruteurService.getOneRecruteur(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneRecruteur(@PathVariable long id){
		try {
			recruteurService.deleteOneRecruteur(id);
			return ResponseEntity.ok("candiature "+ id +"deleted successfully ");
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error during delete "+ ex.getMessage());
		}
	}
}
