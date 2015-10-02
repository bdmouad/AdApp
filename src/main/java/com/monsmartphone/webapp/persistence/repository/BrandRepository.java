package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

	List<Brand> findByNameLike(String string);

}
