package com.Duitto.service;

import java.util.HashMap;
import java.util.Optional;

import com.Duitto.dto.UserDto;
import com.Duitto.model.ConfirmationTokenModel;
import com.Duitto.model.CustomerRegistrationModel;
import com.Duitto.model.JWTTOkenModel;

public interface CustomerService {

	HashMap<String, Object> registerCustomer(UserDto customer);

	HashMap<String, Object> customerSignIn(UserDto customer);

	void saveConfirmationToken(ConfirmationTokenModel confirmationToken);

	HashMap<String, Object> confirmUser(ConfirmationTokenModel confirmationToken);

	boolean deleteConfirmationToken(Long pkId);

	Optional<ConfirmationTokenModel> findByConfirmationToken(String token);

	HashMap<String, Object> loginVerification(String token);

	void saveJWTToken(JWTTOkenModel jwtToken);
}
