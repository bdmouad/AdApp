package com.monsmartphone.webapp.controller;

import java.util.ArrayList;
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

import com.monsmartphone.webapp.persistence.entity.User;
import com.monsmartphone.webapp.persistence.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return repo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User findOne(@PathVariable("id") final Long id) {
		if (id == null)
			return new User();
		return repo.findOne(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findFiltered(@RequestParam String pattern) {
		return repo.findByTelLike("%" + pattern + "%");
	}

	@RequestMapping(value = "/search/byRoleId", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findFilteredByRole(@RequestParam Long id) {
		List<User> list = new ArrayList<>();
		for (User u : findAll()) {
			if (u.getRole().getId() == id)
				list.add(u);
		}
		return list;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public User create(@RequestBody final User resource) {
		User u;
		u = repo.save(resource);
		return u;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		repo.delete(id);
	}

}