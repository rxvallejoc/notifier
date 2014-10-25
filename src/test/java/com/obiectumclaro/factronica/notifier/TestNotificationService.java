package com.obiectumclaro.factronica.notifier;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestNotificationService {
    
    @Test
    public void shouldMarkAttemptAsInProgressIfNotFulfilledYet() {
	final Recipient recipient = new Recipient("1716151413", "John Doe", "jhon@customer.com");
	final Authorization authorization = new Authorization(recipient, "invoice".getBytes());
	final NotificationRequest request = NotificationsRepository.createRequest(authorization);
	final NotificationService service = new NotificationService();
	
	final NotificationResponse response = service.attempt(request);
	
	assertThat(response.getStatus(), is(NotificationStatus.DELIVERING));
    }
    
}
