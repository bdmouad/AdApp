package com.monsmartphone.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
		if (id == null)
			return new Ad();
		return repo.findOne(id);
	}

	@RequestMapping(value = "/searchByTitle", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByTitle(@RequestParam String pattern) {
		return repo.findByTitleLike("%" + pattern + "%");
	}

	@RequestMapping(value = "/searchByAdtext", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByAdtext(@RequestParam String pattern) {
		return repo.findByAdtextLike("%" + pattern + "%");
	}

	@RequestMapping(value = "/searchByUsername", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByUsername(@RequestParam String pattern) {
		return repo.findByUsernameLike("%" + pattern + "%");
	}

	@RequestMapping(value = "/{id}/photos", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getPhotosBytesById(@PathVariable("id") final Long id) {
		List<String> list = new ArrayList<>();
		Ad ad = repo.findOne(id);
		list.add(ad.getPhoto1());
		list.add(ad.getPhoto2());
		list.add(ad.getPhoto3());
		return list;
	}

	@RequestMapping(value = "/{id}/photo1", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getPhoto1ById(@PathVariable("id") final Long id) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<String>(repo.findOne(id).getPhoto1(), headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/photo2", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> findPhoto2ById(@PathVariable("id") final Long id) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<String>(repo.findOne(id).getPhoto2(), headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/photo3", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> findPhoto3ById(@PathVariable("id") final Long id) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<String>(repo.findOne(id).getPhoto3(), headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/searchByCity", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByCity(@RequestParam String pattern) {
		return repo.findByCityLike("%" + pattern + "%");
	}

	@RequestMapping(value = "/searchByZip", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByZip(@RequestParam String pattern) {
		return repo.findByZipLike(pattern);
	}

	@RequestMapping(value = "/price", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByPrice(@RequestParam Long price) {
		List<Ad> list = new ArrayList<>();
		for (Ad ad : findAll()) {
			if (ad.getPrice() == price)
				list.add(ad);
		}
		return list;
	}

	@RequestMapping(value = "/priceUp", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByPriceUp(@RequestParam Long price) {
		List<Ad> list = new ArrayList<>();
		for (Ad ad : findAll()) {
			if (ad.getPrice() > price)
				list.add(ad);
		}
		return list;
	}

	@RequestMapping(value = "/priceDown", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findFilteredByPriceDown(@RequestParam Long price) {
		List<Ad> list = new ArrayList<>();
		for (Ad ad : findAll()) {
			if (ad.getPrice() < price)
				list.add(ad);
		}
		return list;
	}

	@RequestMapping(value = "/model/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findfilteredByModel(@PathVariable("id") final Long id) {
		List<Ad> list = new ArrayList<>();
		for (Ad ad : findAll()) {
			if (ad.getModel().getId() == id)
				list.add(ad);
		}
		return list;
	}

	@RequestMapping(value = "/byModel", method = RequestMethod.GET)
	@ResponseBody
	public List<Ad> findfilteredByModelName(@RequestParam final String pattern) {
		List<Ad> list = new ArrayList<>();
		for (Ad ad : findAll()) {
			if (ad.getModel().getName().contains(pattern))
				list.add(ad);
		}
		return list;
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
