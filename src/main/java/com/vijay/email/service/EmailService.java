package com.vijay.email.service;

import java.util.List;
import java.util.UUID;

import com.vijay.email.domain.Email;

/**
 * 
 * @author vijay
 *
 */
public interface EmailService {

    List<Email> listAll();

    Email getById(UUID id);

    Email saveOrUpdate(Email email);

    void delete(UUID id);

	Email saveOrUpdateEmail(Email email);

}
