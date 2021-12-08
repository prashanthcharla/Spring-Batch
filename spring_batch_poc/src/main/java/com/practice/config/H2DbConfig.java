package com.practice.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class H2DbConfig {
	
	private final H2DbConfigProps configProps;
	
	public H2DbConfig(H2DbConfigProps configProps) {
		super();
		this.configProps = configProps;
	}

	@Bean(name = "h2DataBase")
	public DataSource getH2DataSource() {
		return DataSourceBuilder.create().url(configProps.getUrl())
				.username(configProps.getUserName()).password(configProps.getPassword())
				.driverClassName(configProps.getDriverClassName()).build();
	}
}
