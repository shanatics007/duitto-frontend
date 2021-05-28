package com.Duitto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Duitto.model.CustomerRegistrationModel;

public interface CustomerRepository extends CrudRepository<CustomerRegistrationModel, Long>{

	
	
	Optional<CustomerRegistrationModel> findOneByEmail(String email);
	
	CustomerRegistrationModel findByEmail(String email);


	
}
