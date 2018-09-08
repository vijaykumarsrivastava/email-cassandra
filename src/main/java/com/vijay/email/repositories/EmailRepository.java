package com.vijay.email.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.vijay.email.domain.Email;

/**
 * 
 * @author vijay
 *
 */
public interface EmailRepository extends CrudRepository<Email, UUID> {
}
