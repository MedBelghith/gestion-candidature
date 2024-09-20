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

import com.elitech.gcandidate.dtos.EntretienDto;
import com.elitech.gcandidate.services.EntretienService;

import lombok.AllArgsConstructor;
@RequestMapping("entretien")
@RestController
@AllArgsConstructor
public class EntretienController {

	EntretienService entretienService;
	
	@PostMapping
	public EntretienDto createOneEntretien(@RequestBody EntretienDto candidiatDto) {
		return entretienService.createOneEntretien(candidiatDto);
	}
	@GetMapping
	public ResponseEntity<Page<EntretienDto>> getAllEntretien(){
		Pageable pageable = PageRequest.of(0, 10);
		return ResponseEntity.ok().body(entretienService.getAllEntretien(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<EntretienDto> getOneEntretien(@PathVariable long id){
		return ResponseEntity.ok(entretienService.getOneEntretien(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneEntretien(@PathVariable long id){
		try {
			entretienService.deleteOneEntretien(id);
			return ResponseEntity.ok("candiature "+ id +"deleted successfully ");
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error during delete "+ ex.getMessage());
		}
	}
}
