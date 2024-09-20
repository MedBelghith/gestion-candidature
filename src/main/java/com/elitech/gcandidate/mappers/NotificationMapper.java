package com.elitech.gcandidate.mappers;

import org.modelmapper.ModelMapper;

import com.elitech.gcandidate.dtos.NotificationDto;
import com.elitech.gcandidate.entities.Notification;

public class NotificationMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	public static NotificationDto convertToDTO(Notification notification)
	{
	return modelMapper.map(notification, NotificationDto.class);
	}

	public static Notification convertToEntity(NotificationDto notificationDto)
	{
	return modelMapper.map(notificationDto, Notification.class);	
	}
}
