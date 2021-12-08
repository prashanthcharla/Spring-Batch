package com.practice.iServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.LastName;
import com.practice.iService.LastNameService;
import com.practice.repository.LastNameRepository;

@Service
public class LastNameServiceImpl implements LastNameService {

	@Autowired
	LastNameRepository lastNameRepo;

	@Override
	public LastName save(LastName lastName) {
		return lastNameRepo.save(lastName);
	}

	@Override
	public List<LastName> getAllLastNames() {
		return lastNameRepo.findAll();
	}

}
