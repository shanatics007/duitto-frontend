package com.Duitto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Duitto.model.ConfirmationTokenModel;
import com.Duitto.model.JWTTOkenModel;

public interface JWTTokenRepository extends CrudRepository<JWTTOkenModel, Long> {

    Optional<JWTTOkenModel> findByJWTToken(String token);

	
		
	}
