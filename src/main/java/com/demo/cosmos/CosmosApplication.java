package com.demo.cosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CosmosApplication implements CommandLineRunner {

	@Autowired
	private ReadPrimaryCustomerRepository writeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}

	public void run(String... var1) throws Exception {
		// final User testUser = new User("testId", "testFirstName", "testLastName");

		// save a couple of customers
		writeRepository.save(new Customer("Alice", "Smith"));
		writeRepository.save(new Customer("Bob", "Smith"));

		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : writeRepository.findAll()) {
			System.out.println(customer);
		}

		System.out.println();
	}
}
