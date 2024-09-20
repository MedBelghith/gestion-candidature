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

import com.elitech.gcandidate.dtos.NotificationDto;
import com.elitech.gcandidate.services.NotificationService;

import lombok.AllArgsConstructor;
@RequestMapping("notification")
@RestController
@AllArgsConstructor
public class NotificationController {

	NotificationService notificationService;
	
	@PostMapping
	public NotificationDto createOneNotification(@RequestBody NotificationDto notificationDto) {
		return notificationService.createOneNotification(notificationDto);
	}
	@GetMapping
	public ResponseEntity<Page<NotificationDto>> getAllNotification(){
		Pageable pageable = PageRequest.of(0, 10);
		return ResponseEntity.ok().body(notificationService.getAllNotification(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<NotificationDto> getOneNotification(@PathVariable long id){
		return ResponseEntity.ok(notificationService.getOneNotification(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneNotification(@PathVariable long id){
		try {
			notificationService.deleteOneNotification(id);
			return ResponseEntity.ok("candiature "+ id +"deleted successfully ");
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error during delete "+ ex.getMessage());
		}
	}
}
