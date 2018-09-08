package com.vijay.email.controller;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vijay.email.domain.Email;
import com.vijay.email.service.EmailService;
import com.vijay.email.util.ResourceUtil;
import com.vijay.email.util.ResponseUtility;

/**
 * 
 * @author vijay
 *
 */
@Controller
@RequestMapping("/email")
public class EmailController implements ResourceUtil {

	private EmailService emailService;

	@Autowired
	public void setEmailService(final EmailService emailService) {
		this.emailService = emailService;
	}

	@RequestMapping({ "/list", "/" })
	public ResponseEntity<?> listEmails() {
		return ResponseUtility.ok(emailService.listAll());
	}

	@RequestMapping("/{id}")
	public ResponseEntity<?> getEmail(final @PathVariable String id) {
		return ResponseUtility.ok(emailService.getById(UUID.fromString(id)));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdateEmail(@Valid @RequestBody final Email email) {
		final Email savedEmail = emailService.saveOrUpdateEmail(email);
		final URI newResource = getCurrentURI().resolve(String.valueOf(savedEmail.getId()));
		return ResponseUtility.created(savedEmail, newResource);
	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity<?> delete(final @PathVariable String id) {
		emailService.delete(UUID.fromString(id));
		return ResponseUtility.no_content();
	}

}
