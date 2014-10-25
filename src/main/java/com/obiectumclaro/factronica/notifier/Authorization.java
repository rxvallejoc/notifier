package com.obiectumclaro.factronica.notifier;

public class Authorization {

    private final Recipient recipient;
    private byte[] invoice;
    
    protected Authorization(final Recipient recipient, final byte[] invoice) {
	this.recipient = recipient;
	this.invoice = invoice;
    }

}
