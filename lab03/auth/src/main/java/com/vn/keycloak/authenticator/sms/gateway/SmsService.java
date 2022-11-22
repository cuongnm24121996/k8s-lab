package com.vn.keycloak.authenticator.sms.gateway;

/**
 * @author cuongnm
 */
public interface SmsService {

	void send(String phoneNumber, String message);

}
