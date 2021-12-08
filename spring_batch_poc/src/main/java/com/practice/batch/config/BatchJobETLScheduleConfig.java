package com.practice.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class BatchJobETLScheduleConfig {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier(value = "customerJob")
	private Job customerJob;

	@Scheduled(fixedRate = 5000)
	public void scheduledJob() {
		runBatchJob(customerJob);
	}

	private void runBatchJob(Job job) {
		JobParameters parameters = new JobParametersBuilder()
				.addString("Customer ETL -> Person + Last Name", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();

		try {
			jobLauncher.run(job, parameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
