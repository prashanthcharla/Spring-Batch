package com.practice.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchJobETLConfig {

	@Autowired
	@Qualifier(value = "readPersonsData")
	private Step readPersonData;

	@Autowired
	@Qualifier(value = "readLastNamesData")
	private Step readLastNameData;

	@Autowired
	@Qualifier(value = "writeDataToCustomerTable")
	private Step writeDataToCustomer;

	@Autowired
	private JobBuilderFactory builderFactory;

	@Bean(name = "customerJob")
	public Job customerJob() {
		return builderFactory.get("Customer Job").start(readPersonData).next(readLastNameData).next(writeDataToCustomer)
				.build();
	}
}
