package com.elitech.gcandidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.gcandidate.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
