package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

	List<Model> findByNameLike(String string);

}
