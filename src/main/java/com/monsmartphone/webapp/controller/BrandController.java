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

import com.monsmartphone.webapp.persistence.entity.Brand;
import com.monsmartphone.webapp.persistence.entity.Model;
import com.monsmartphone.webapp.persistence.repository.BrandRepository;

@RestController
@RequestMapping(value = "/api/brands")
public class BrandController {

	@Autowired
	private BrandRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Brand> findAll() {
		return repo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Brand findOne(@PathVariable("id") final Long id) {
		if (id == null)
			return new Brand();
		return repo.findOne(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Brand> findFiltered(@RequestParam String pattern) {
		return repo.findByNameLike("%" + pattern + "%");
	}

	@RequestMapping(value = "/brand/forModel/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Brand findForModel(@PathVariable("id") final Long id) {
		Brand thebrand = null;
		for (Brand b : findAll()) {
			for (Model m : b.getModels()) {
				if (m.getId() == id) {
					thebrand = b;
				}
			}
		}
		return thebrand;
	}

	@RequestMapping(value = "/brand/forModel", method = RequestMethod.GET)
	@ResponseBody
	public List<Brand> findForModelLike(@RequestParam String pattern) {
		List<Brand> list = new ArrayList<>();
		for (Brand b : findAll()) {
			for (Model m : b.getModels()) {
				if (m.getName().contains(pattern))
					list.add(b);
			}
		}
		return list;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Brand create(@RequestBody final Brand resource) {
		Brand b;
		b = repo.save(resource);
		return b;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		repo.delete(id);
	}

}
