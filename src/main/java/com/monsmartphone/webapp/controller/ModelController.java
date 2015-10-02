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

import com.monsmartphone.webapp.persistence.entity.Model;
import com.monsmartphone.webapp.persistence.repository.ModelRepository;

@RestController
@RequestMapping(value = "/api/models")
public class ModelController {
	
	@Autowired
	private ModelRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Model> findAll() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Model findOne(@PathVariable("id") final Long id) {
		if (id == null) return new Model();
		return repo.findOne(id);
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Model> findFiltered(@RequestParam String pattern) {		
		return repo.findByNameLike( "%" + pattern + "%");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Model create(@RequestBody final Model resource) {
		Model m;
		m = repo.save(resource);
		return m;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		repo.delete(id);
	}

}
