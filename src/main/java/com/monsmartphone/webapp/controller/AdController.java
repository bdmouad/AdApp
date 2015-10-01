package com.monsmartphone.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
