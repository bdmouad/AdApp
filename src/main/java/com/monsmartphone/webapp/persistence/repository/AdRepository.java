package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

	List<Ad> findByAdtextLike(String string);

}
