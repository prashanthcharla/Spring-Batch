package com.practice.batch.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.batch.steps.ReadLastNameData;
import com.practice.batch.steps.ReadPersonData;
import com.practice.batch.steps.WriteDataToCustomer;

@Configuration
public class StepsConfigurer {

	@Autowired
	private ReadPersonData readPersonData;

	@Autowired
	private ReadLastNameData readLastNameData;

	@Autowired
	private WriteDataToCustomer writeDataToCustomer;

	@Autowired
	private StepBuilderFactory builderFactory;

	@Bean(name = "readPersonsData")
	public Step getReadPersonDataStep() {
		return builderFactory.get("Read Person Data").tasklet(readPersonData).build();
	}

	@Bean(name = "readLastNamesData")
	public Step getReadLastNamesDataStep() {
		return builderFactory.get("Read Last Names Data").tasklet(readLastNameData).build();
	}

	@Bean(name = "writeDataToCustomerTable")
	public Step getwriteDataToCustomerStep() {
		return builderFactory.get("Write data to Customer").tasklet(writeDataToCustomer).build();
	}
}
