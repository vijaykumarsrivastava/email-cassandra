package com.vijay.email.util;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * 
 * @author vijay
 *
 */
public final class ResponseUtility {

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	private static final MultiValueMap<String, String> CONTENT_TYPE_HEADER = new HttpHeaders();
	static {
		CONTENT_TYPE_HEADER.add(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE);
	}

	// Don't allow to construct.
	private ResponseUtility() {
	}

	/**
	 * 400 Bad Request (HTTP/1.1 - RFC 2616)
	 * 
	 * @return response
	 */
	public static ResponseEntity<?> bad_request() {
		return new ResponseEntity<>(CONTENT_TYPE_HEADER, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 409 Conflict (HTTP/1.1 - RFC 2616)
	 * 
	 * @return response
	 */
	public static ResponseEntity<?> conflict() {
		return new ResponseEntity<>(CONTENT_TYPE_HEADER, HttpStatus.CONFLICT);
	}

	//// 2xx
	/**
	 * 200 OK.
	 * 
	 * @return response
	 */
	@SuppressWarnings("PMD.ShortMethodName")
	public static ResponseEntity<?> ok() { // NOPMD
		return new ResponseEntity<>(CONTENT_TYPE_HEADER, HttpStatus.OK);
	}

	/**
	 * 200 OK.
	 * 
	 * @param entity response entity
	 * @return response
	 */
	@SuppressWarnings("PMD.ShortMethodName")
	public static ResponseEntity<?> ok(final Object entity) { // NOPMD
		return new ResponseEntity<>(entity, CONTENT_TYPE_HEADER, HttpStatus.OK);
	}

	/**
	 * 201 Created.
	 * 
	 * @param entity   response entity
	 * @param location location header value
	 * @return response
	 */
	public static ResponseEntity<?> created(final Object entity, final URI location) {
		final MultiValueMap<String, String> header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE);
		if (location != null) {
			header.add(HttpHeaders.LOCATION, location.toString());
		}
		return new ResponseEntity<>(entity, header, HttpStatus.CREATED);
	}

	/**
	 * 202 Accepted.
	 * 
	 * @return response
	 */
	public static ResponseEntity<?> accepted() {
		return new ResponseEntity<>(CONTENT_TYPE_HEADER, HttpStatus.ACCEPTED);
	}

	/**
	 * 204 No Content (HTTP/1.0 - RFC 1945)
	 * 
	 * @return response
	 */
	public static ResponseEntity<?> no_content() {
		return new ResponseEntity<>(CONTENT_TYPE_HEADER, HttpStatus.NO_CONTENT);
	}

}
