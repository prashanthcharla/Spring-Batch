package com.practice.iServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.Person;
import com.practice.iService.PersonService;
import com.practice.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepo;

	@Override
	public Person save(Person person) {
		return personRepo.save(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}

}
