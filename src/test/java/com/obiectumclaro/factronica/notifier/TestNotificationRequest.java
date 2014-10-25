package com.obiectumclaro.factronica.notifier;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestNotificationRequest {
    
    private Authorization authorization;
    
    @Before
    public void setUpCollaborators() {
	final Recipient recipient = new Recipient("1716151413", "John Doe", "jhon@customer.com");
	authorization = new Authorization(recipient, "invoice".getBytes());
    }
    
    @Test
    public void shouldDefineEqualityBasedOnKey() {
	final NotificationRequest a = new NotificationRequest("a-key", authorization);
	final NotificationRequest b = new NotificationRequest("a-key", authorization);
	
	assertThat(a, is(equalTo(b)));
    }
    
    @Test
    public void shouldDefineDifferenceBasedOnKey() {
	final NotificationRequest a = new NotificationRequest("a-key", authorization);
	final NotificationRequest b = new NotificationRequest("b-key", authorization);
	
	assertThat(a, is(not(equalTo(b))));
    }
    
    @Test
    public void shouldKeepHashcodeConsistent() {
	final NotificationRequest a = new NotificationRequest("a-key", authorization);
	final NotificationRequest b = new NotificationRequest("a-key", authorization);
	
	assertThat(a.hashCode(), is(equalTo(b.hashCode())));
    }
    
    @Test
    public void shouldRecordTimeOfCreation() {
	final NotificationRequest request = new NotificationRequest("key", authorization);
	
	assertThat(request.getCreated(), is(notNullValue()));
    }

}
