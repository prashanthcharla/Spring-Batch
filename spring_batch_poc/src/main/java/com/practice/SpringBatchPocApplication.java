package com.practice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.practice.config.H2DbConfigProps;

@EnableConfigurationProperties({ H2DbConfigProps.class })
@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchPocApplication.class, args);
	}

}