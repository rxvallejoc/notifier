package com.obiectumclaro.factronica.notifier;

import java.util.UUID;

public abstract class NotificationsRepository {

    public static NotificationRequest createRequest(final Authorization authorization) {
	final String uuid = UUID.randomUUID().toString();
	return new NotificationRequest(uuid, authorization);
    }

    public static NotificationResponse createResponseFor(final NotificationRequest request) {
	final NotificationResponse response = new NotificationResponse(request.getKey());
	response.setStatus(NotificationStatus.DELIVERING);
	return response;
    }

    public static NotificationResponse createSuccesfulResponseFor(NotificationRequest request) {
	final NotificationResponse response = createResponseFor(request);
	response.setStatus(NotificationStatus.DELIVERED);
	return response;
    }

}
