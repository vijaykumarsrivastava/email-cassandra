package com.vijay.email.demo;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vijay.email.domain.Email;

/**
 * 
 * @author vijay
 *
 */
public class TestEmail {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void testSerializable() throws JsonProcessingException {
		final Email email = new Email();
		email.setMessage("message");
		email.setRecipient("recipient");
		email.setSender("sender");
		email.setSubject("subject");
		final String jsonValue = objectMapper.writeValueAsString(email);
		System.out.println(jsonValue);
	}
}
