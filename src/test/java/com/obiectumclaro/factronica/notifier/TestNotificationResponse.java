package com.obiectumclaro.factronica.notifier;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestNotificationResponse {
    
    @Test
    public void shouldDefineEqualityBasedOnKey() {
	final NotificationResponse a = new NotificationResponse("a-key");
	final NotificationResponse b = new NotificationResponse("a-key");
	
	assertThat(a, is(equalTo(b)));
    }
    
    @Test
    public void shouldDefineDifferenceBasedOnKey() {
	final NotificationResponse a = new NotificationResponse("a-key");
	final NotificationResponse b = new NotificationResponse("b-key");
	
	assertThat(a, is(not(equalTo(b))));
    }
    
    @Test
    public void shouldKeepHashcodeConsistent() {
	final NotificationResponse a = new NotificationResponse("a-key");
	final NotificationResponse b = new NotificationResponse("a-key");
	
	assertThat(a.hashCode(), is(equalTo(b.hashCode())));
    }
    
    @Test
    public void shouldRecordTimeOfCreation() {
	final NotificationResponse response = new NotificationResponse("key");
	
	assertThat(response.getCreated(), is(notNullValue()));
    }

}
