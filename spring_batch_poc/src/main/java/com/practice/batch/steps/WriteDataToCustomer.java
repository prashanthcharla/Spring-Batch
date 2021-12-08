package com.practice.batch.steps;

import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.dto.Customer;
import com.practice.dto.LastName;
import com.practice.dto.Person;
import com.practice.repository.CustomerRepository;

@Component
public class WriteDataToCustomer implements Tasklet, StepExecutionListener {

	@Autowired
	private CustomerRepository customerRepository;

	private List<Person> persons;
	private List<LastName> lastNames;

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		ExecutionContext executionContext = stepExecution.getJobExecution().getExecutionContext();
		persons = (List<Person>) executionContext.get("persons");
		lastNames = (List<LastName>) executionContext.get("lastNames");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return ExitStatus.COMPLETED;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Customer customer;
		for (int i = 0; i < persons.size(); i++) {
			customer = new Customer();
			customer.setFirstName(persons.get(i).getFirstName());
			customer.setLastName(lastNames.get(i).getLastName());
			customer.setAge(persons.get(i).getAge());
			customerRepository.save(customer);
		}
		return RepeatStatus.FINISHED;
	}

}
