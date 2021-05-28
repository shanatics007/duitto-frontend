package com.Duitto.serviceimpl;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Duitto.config.JwtTokenUtil;
import com.Duitto.converter.UserConverter;
import com.Duitto.dto.Mail;
import com.Duitto.dto.UserDto;
import com.Duitto.model.ConfirmationTokenModel;
import com.Duitto.model.CustomerRegistrationModel;
import com.Duitto.model.JWTTOkenModel;
import com.Duitto.repository.ConfirmationTokenRepository;
import com.Duitto.repository.CustomerRepository;
import com.Duitto.repository.JWTTokenRepository;
import com.Duitto.service.CustomerService;
import com.Duitto.service.MailService;
import com.Duitto.utility.MailUtils;
import com.Duitto.utility.MethodsUtility;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepos;

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	JWTTokenRepository jwtTokenRepository;
	
	@Autowired
	MailService mailService;

	@Override
	public HashMap<String, Object> registerCustomer(UserDto customerDto) {
		HashMap<String, Object> map = new HashMap();

		try {

			Optional<CustomerRegistrationModel> user = custRepos.findOneByEmail(customerDto.getEmail());
			if (user.isPresent()) {
				map.put("message", "Email already registered!");
				map.put("status", false);
			} else {
				map.put("data", custRepos.save(UserConverter.dtoToEntity(customerDto)));
				map.put("status", true);
				ConfirmationTokenModel confirmationToken = new ConfirmationTokenModel(customerDto.getEmail(),
				MethodsUtility.getCurrentTimestamp());
				saveConfirmationToken(confirmationToken);
				Mail mail = MailUtils.emailVerification(confirmationToken, customerDto.getEmail());
				mailService.sendEmail(mail);
			}
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("status", false);
		}

		return map;
	}

	@Override
	public HashMap<String, Object> customerSignIn(UserDto customer) {
		HashMap<String, Object> map = new HashMap();
		Optional<CustomerRegistrationModel> option = custRepos.findOneByEmail(customer.getEmail());
		try {
			if (option.isPresent()) {
				
				 String token= new JwtTokenUtil().generateToken(option.get());
				 JWTTOkenModel jwtToken = new JWTTOkenModel(token, MethodsUtility.getCurrentTimestamp(), customer.getEmail());
				 saveJWTToken(jwtToken);
				 UserDto dto =UserConverter.entityToDto(option.get());
				 map.put("data", dto);
				 Mail mail = MailUtils.emailAtLogin(dto,token);
				 mailService.sendEmail(mail);
				 map.put("token",token);
				 map.put("status", true);
			}

			else {
				map.put("mesage", "No Customer Found");
				map.put("status", false);
			}
		} catch (Exception e) {
			map.put("mesage", e.getMessage());
			map.put("status", false);
		}
		
		return map;
	}

	@Override
	public void saveConfirmationToken(ConfirmationTokenModel confirmationToken) {
		confirmationTokenRepository.save(confirmationToken);
	}
	
	@Override
	public void saveJWTToken(JWTTOkenModel jwtToken) {
		jwtTokenRepository.save(jwtToken);
	}

	@Override
	public HashMap<String, Object> confirmUser(ConfirmationTokenModel confirmationToken) {
		HashMap<String, Object> map = new HashMap();
		boolean status = false;
		try {

			String cusEmail = confirmationToken.getCusEmail();
			final CustomerRegistrationModel customer = custRepos.findByEmail(cusEmail);
			if (customer == null) {
				throw new UsernameNotFoundException(cusEmail);
			}
			customer.setEnabled(true);
			custRepos.save(customer);

			status = deleteConfirmationToken(confirmationToken.getId());
			if (status == true) {
				map.put("status", true);
				map.put("message", "success");
			} else {
				map.put("status", false);
				map.put("message", "Something went wrong in token deletion.");
			}
		} catch (Exception e) {
			map.put("status", false);
			map.put("message", e.getMessage());
		}

		return map;

	}

	@Override
	public boolean deleteConfirmationToken(Long pkId) {
		boolean status = false;
		try {
			confirmationTokenRepository.deleteById(pkId);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;

	}

	@Override
	public Optional<ConfirmationTokenModel> findByConfirmationToken(String token) {

		return confirmationTokenRepository.findByConfirmationToken(token);
	}

	@Override
	public HashMap<String, Object> loginVerification(String token) {
		HashMap<String, Object> map = new HashMap();
		boolean status = false;
		try {
			final Optional<JWTTOkenModel> jwtToken = jwtTokenRepository.findByJWTToken(token);
			if(token.equals(jwtToken))
			{
				map.put("status", true);
			}
			else {
				map.put("status", false);
			}
		}catch (Exception e) {
			map.put("status", false);
			map.put("message", e.getMessage());
		}
		return map;
	}

}
