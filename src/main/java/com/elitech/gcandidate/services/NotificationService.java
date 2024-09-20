package com.elitech.gcandidate.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.gcandidate.dtos.NotificationDto;


public interface NotificationService {

	public NotificationDto createOneNotification (NotificationDto notificationDto);
	public NotificationDto getOneNotification (long id);
	public Page<NotificationDto> getAllNotification (Pageable pageable);
	public void deleteOneNotification(long id);
}
