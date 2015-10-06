package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.Connexion;

public interface ConnexionRepository extends JpaRepository<Connexion, Long> {

	List<Connexion> findByIpLike(String string);
	List<Connexion> findByCountryLike(String string);
	List<Connexion> findByDeviceLike(String string);
	List<Connexion> findByOsLike(String string);
	List<Connexion> findByBrowserLike(String string);

}
