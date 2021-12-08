package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.LastName;
import com.practice.iService.LastNameService;

@RestController
@RequestMapping("/api/lastName")
public class LastNameController {

	@Autowired
	LastNameService lastNameService;

	@PostMapping(value = "/save")
	public ResponseEntity<LastName> saveLastName(@RequestBody LastName lastName) {
		return new ResponseEntity<>(lastNameService.save(lastName), HttpStatus.OK);
	}

}
