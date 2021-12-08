package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.Person;
import com.practice.iService.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping(value = "/save")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
	}

}
