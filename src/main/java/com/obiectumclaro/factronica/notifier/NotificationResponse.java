package com.obiectumclaro.factronica.notifier;

import java.time.Instant;

public class NotificationResponse {

    private final String key;
    private final Instant created;
    private NotificationStatus status;
    
    NotificationResponse(final String key) {
	this.key = key;
	this.created = Instant.now();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((key == null) ? 0 : key.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	NotificationResponse other = (NotificationResponse) obj;
	if (key == null) {
	    if (other.key != null)
		return false;
	} else if (!key.equals(other.key))
	    return false;
	return true;
    }

    public String getKey() {
        return key;
    }

    public Instant getCreated() {
        return created;
    }

    public NotificationStatus getStatus() {
        return status;
    }
    
    void setStatus(final NotificationStatus status) {
	this.status = status;
    }

}
