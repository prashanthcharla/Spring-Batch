package com.practice.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

	@Autowired
	@Qualifier(value = "h2DataBase")
	DataSource dataSource;

	@Bean
	BatchConfigurer configurer() {
		return new DefaultBatchConfigurer(dataSource);
	}

}
