package com.Duitto.controller;

import java.util.HashMap;
import java.util.Optional;

import com.Duitto.dto.UserDto;
import com.Duitto.model.ConfirmationTokenModel;
import com.Duitto.model.CustomerRegistrationModel;
import com.Duitto.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@PostMapping("/signup")
	public HashMap<String, Object> customerSignUp(@RequestBody UserDto customer) {

		return customerservice.registerCustomer(customer);

	}

	@PostMapping("/signin")
	public HashMap<String, Object> customerSignIn(@RequestBody UserDto customer) {

		return customerservice.customerSignIn(customer);

	}

	@GetMapping("/confirm/{token}")
	public HashMap<String, Object> confirmMail(@PathVariable String token) {
		HashMap<String, Object> map = new HashMap();
		Optional<ConfirmationTokenModel> optionalConfirmationToken = customerservice.findByConfirmationToken(token);
		if (optionalConfirmationToken.isPresent()) {
			map = customerservice.confirmUser(optionalConfirmationToken.get());
		} else {
			map.put("status", false);
			map.put("message", "Link expired");
		}
		return map;
	}

	@GetMapping("/loginVerification/{token}")
	public HashMap<String, Object> loginVerification(@PathVariable String token) {

		return customerservice.loginVerification(token);

	}

	@GetMapping("/test")
	public String Test() {
		HashMap<String, Object> resp = new HashMap<>();

		return "test";
	}

}
