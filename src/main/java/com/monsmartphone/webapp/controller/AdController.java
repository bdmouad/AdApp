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

import com.monsmartphone.webapp.persistence.entity.Ad;
import com.monsmartphone.webapp.persistence.repository.AdRepository;

@RestController
@RequestMapping(value = "/api/ads")
public class AdController {

	@Autowired
	private AdRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findAll() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Ad findOne(@PathVariable("id") final Long id) {
		if (id == null) return new Ad();
		return repo.findOne(id);
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFiltered(@RequestParam String pattern) {		
		return repo.findByAdtextLike( "%" + pattern + "%");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Ad create(@RequestBody final Ad resource) {
		Ad ad;
		ad = repo.save(resource);
		return ad;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		repo.delete(id);
	}

}
