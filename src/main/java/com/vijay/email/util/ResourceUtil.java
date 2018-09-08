package com.vijay.email.util;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * @author vijay
 *
 */
public interface ResourceUtil {

	/**
	 * Retrieved current uri.
	 * 
	 * @return current uri.
	 */
	default UriComponentsBuilder getUriComponentsBuilder() {
		String SEPARATE_PATH = "/";
		final HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
		String currentUri = httpServletRequest.getRequestURL().toString();
		if (!currentUri.endsWith(SEPARATE_PATH)) {
			final StringBuilder builder = new StringBuilder(currentUri);
			builder.append(SEPARATE_PATH);
			currentUri = builder.toString();
		}
		final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(currentUri);
		if (builder == null) {
			throw new IllegalStateException("Unable to current uri.");
		}
		return builder;
	}

	/**
	 * 
	 * @return current uri.
	 */
	@SuppressWarnings("null")
	default URI getCurrentURI() {
		return getUriComponentsBuilder().build().toUri();
	}

}
