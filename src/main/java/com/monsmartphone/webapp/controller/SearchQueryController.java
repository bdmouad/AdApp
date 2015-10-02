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

import com.monsmartphone.webapp.persistence.entity.SearchQuery;
import com.monsmartphone.webapp.persistence.repository.SearchQueryRepository;

@RestController
@RequestMapping(value = "/api/searchqueries")
public class SearchQueryController {

	@Autowired
	private SearchQueryRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<SearchQuery> findAll() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public SearchQuery findOne(@PathVariable("id") final Long id) {
		if (id == null) return new SearchQuery();
		return repo.findOne(id);
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public List<SearchQuery> findFiltered(@RequestParam String pattern) {		
		return repo.findByQueryLike( "%" + pattern + "%");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public SearchQuery create(@RequestBody final SearchQuery resource) {
		SearchQuery sq;
		sq = repo.save(resource);
		return sq;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		repo.delete(id);
	}

}
