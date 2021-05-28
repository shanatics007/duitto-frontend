package com.Duitto.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Duitto.model.CustomerRegistrationModel;
import com.Duitto.repository.CustomerRepository;

@Service("UserDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	CustomerRepository custRepos;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) {
	        final CustomerRegistrationModel customer = custRepos.findByEmail(username);
	        if (customer == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        UserDetails user = User.withUsername(customer.getEmail()).authorities(customer.getUserRole()).roles(customer.getUserRole()).build();
	        return user;
	    }


}
