package com.obiectumclaro.factronica.notifier;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestNotificationRequestsRepository {

    private Authorization authorization;
    
    @Before
    public void setUpCollaborators() {
	final Recipient recipient = new Recipient("1716151413", "John Doe", "jhon@customer.com");
	authorization = new Authorization(recipient, "invoice".getBytes());
    }

    @Test
    public void shouldCreateRequestIdentifiedByKey() {
	final NotificationRequest request = NotificationsRepository.createRequest(authorization);
	
	assertThat(request.getKey(), is(notNullValue()));
    }
    
    @Test
    public void shouldCreatedRequestUniquelyIdenfiedByKey() {
	
	final NotificationRequest a = NotificationsRepository.createRequest(authorization);
	final NotificationRequest b = NotificationsRepository.createRequest(authorization);
	
	assertThat(a, is(not(equalTo(b))));
    }

    @Test
    public void shouldCreateResponseWithRequestIdentifier() {
	final NotificationRequest request = NotificationsRepository.createRequest(authorization);
	
	final NotificationResponse response = NotificationsRepository.createResponseFor(request);
	
	assertThat(response.getKey(), is(request.getKey()));
    }
    
    @Test
    public void shouldCreateResponseWithDeliveringStatusByDefault() {
	final NotificationRequest request = NotificationsRepository.createRequest(authorization);
	
	final NotificationResponse response = NotificationsRepository.createResponseFor(request);
	
	assertThat(response.getStatus(), is(NotificationStatus.DELIVERING));
    }
    
    @Test
    public void shouldCreateResponseWithDeliveredStatus() {
	final NotificationRequest request = NotificationsRepository.createRequest(authorization);
	
	final NotificationResponse response = NotificationsRepository.createSuccesfulResponseFor(request);
	
	assertThat(response.getStatus(), is(NotificationStatus.DELIVERED));
    }
}
