package com.vijay.email.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.email.domain.Email;
import com.vijay.email.repositories.EmailRepository;

/**
 * 
 * @author vijay
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private EmailRepository emailRepository;

	@Autowired
	public EmailServiceImpl(final EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}

	@Override
	public List<Email> listAll() {
		final List<Email> emails = new ArrayList<>();
		emailRepository.findAll().forEach(emails::add); // fun with Java 8
		return emails;
	}

	@Override
	public Email getById(final UUID id) {
		return emailRepository.findById(id).orElse(null);
	}

	@Override
	public Email saveOrUpdate(final Email email) {
		emailRepository.save(email);
		return email;
	}

	@Override
	public void delete(final UUID id) {
		emailRepository.deleteById(id);

	}

	@Override
	public Email saveOrUpdateEmail(final Email email) {
		return emailRepository.save(email);
	}

}
