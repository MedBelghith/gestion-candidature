package com.elitech.gcandidate.servicesImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.gcandidate.dtos.NotificationDto;
import com.elitech.gcandidate.entities.Notification;
import com.elitech.gcandidate.mappers.NotificationMapper;
import com.elitech.gcandidate.repositories.NotificationRepository;
import com.elitech.gcandidate.services.NotificationService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class NotificationServiceImp implements NotificationService{

	NotificationRepository notificationRepository;
	@Override
	public NotificationDto createOneNotification(NotificationDto notificationDto) {
		Notification notification = NotificationMapper.convertToEntity(notificationDto);
		return NotificationMapper.convertToDTO(notificationRepository.save(notification));
	}

	@Override
	public Page<NotificationDto> getAllNotification(Pageable pageable) {
		Page<Notification> notifications = notificationRepository.findAll(pageable);

		return notifications.map(NotificationMapper::convertToDTO);
	}

	@Override
	public void deleteOneNotification(long id) {
		if (notificationRepository.findById(id)!=null)
		notificationRepository.deleteById(id);
			else throw new RuntimeException("error deleting notification");
	}

	@Override
	public NotificationDto getOneNotification(long id) {
		Notification notification = notificationRepository.findById(id).orElseThrow(()->new RuntimeException("notification "+ id +" does not exist"));
		return NotificationMapper.convertToDTO(notification);
	}
}