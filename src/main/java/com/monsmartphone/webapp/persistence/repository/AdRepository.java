package com.monsmartphone.webapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

}
