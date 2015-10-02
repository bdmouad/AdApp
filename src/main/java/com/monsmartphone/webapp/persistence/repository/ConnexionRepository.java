package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Connexion;

public interface ConnexionRepository extends JpaRepository<Connexion, Long> {

	List<Connexion> findByCountryLike(String string);

}
