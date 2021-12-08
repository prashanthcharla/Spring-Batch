package com.practice.iService;

import java.util.List;

import com.practice.dto.Person;

public interface PersonService {
	Person save(Person person);

	List<Person> getAllPersons();
}
