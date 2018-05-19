package com.demo.cosmos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadPrimaryCustomerRepository extends MongoRepository<Customer, String> {
	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);
}
