package com.monsmartphone.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	/*
	 * @RequestMapping(value="/search", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public List<User> findFiltered(@RequestParam String
	 * pattern) { return repo.findByNomLike(pattern + "%"); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public User findById(@PathVariable("id") final Long id) {
	 * return repo.findOne(id); }
	 * 
	 * @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ResponseEntity<byte[]>
	 * findPhotoById(@PathVariable("id") final Long id) { final HttpHeaders
	 * headers = new HttpHeaders(); headers.setContentType(MediaType.IMAGE_PNG);
	 * return new ResponseEntity<byte[]>(repo.findOne(id).getPhoto(), headers,
	 * HttpStatus.CREATED); }
	 */

}