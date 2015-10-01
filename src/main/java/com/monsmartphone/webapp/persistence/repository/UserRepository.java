package com.monsmartphone.webapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// public List<User> findByNomLike(String pattern);
}