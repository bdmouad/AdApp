package com.monsmartphone.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.monsmartphone.webapp.persistence.entity.Connexion;
import com.monsmartphone.webapp.persistence.repository.ConnexionRepository;

@RestController
@RequestMapping(value = "/api/connexions")
public class ConnexionController {

	@Autowired
	private ConnexionRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Connexion> findAll() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Connexion findOne(@PathVariable("id") final Long id) {
		if (id == null) return new Connexion();
		return repo.findOne(id);
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Connexion> findFiltered(@RequestParam String pattern) {		
		return repo.findByCountryLike( "%" + pattern + "%");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Connexion create(@RequestBody final Connexion resource) {
		Connexion c;
		c = repo.save(resource);
		return c;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		repo.delete(id);
	}

}
