package com.monsmartphone.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.monsmartphone.webapp.persistence.entity.Role;
import com.monsmartphone.webapp.persistence.repository.RoleRepository;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleController {

	@Autowired
	private RoleRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Role> findAll() {
		return repo.findAll();
	}

}
