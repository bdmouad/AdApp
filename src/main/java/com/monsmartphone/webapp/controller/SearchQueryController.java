package com.monsmartphone.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
