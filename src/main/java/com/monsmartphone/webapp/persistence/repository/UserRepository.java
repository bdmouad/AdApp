package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByTelLike(String string);
	
}