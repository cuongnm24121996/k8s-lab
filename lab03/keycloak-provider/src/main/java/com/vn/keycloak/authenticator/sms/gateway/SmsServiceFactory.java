package com.vn.keycloak.authenticator.sms.gateway;

import org.jboss.logging.Logger;

import java.util.Map;

/**
 * @author cuongnm
 */
public class SmsServiceFactory {

	private static final Logger LOG = Logger.getLogger(SmsServiceFactory.class);

	public static SmsService get(Map<String, String> config) {
		if (Boolean.parseBoolean(config.getOrDefault("simulation", "false"))) {
			return (phoneNumber, message) ->
				LOG.warn(String.format("***** SIMULATION MODE ***** Would send SMS to %s with text: %s", phoneNumber, message));
		} else {
			return new AwsSmsService(config);
		}
	}

}