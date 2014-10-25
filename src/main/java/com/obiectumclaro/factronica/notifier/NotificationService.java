package com.obiectumclaro.factronica.notifier;

public class NotificationService {

    public NotificationResponse attempt(final NotificationRequest request) {
	final NotificationResponse response = NotificationsRepository.createResponseFor(request);
	return response;
    }

}
