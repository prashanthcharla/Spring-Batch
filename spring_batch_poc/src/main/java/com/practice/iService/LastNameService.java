package com.practice.iService;

import java.util.List;

import com.practice.dto.LastName;

public interface LastNameService {
	LastName save(LastName lastName);

	List<LastName> getAllLastNames();
}
