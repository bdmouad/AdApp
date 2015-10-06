package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

	List<Ad> findByTitleLike(String string);
	List<Ad> findByAdtextLike(String string);
	List<Ad> findByUsernameLike(String string);
	List<Ad> findByCityLike(String string);
	List<Ad> findByZipLike(String pattern);

}
