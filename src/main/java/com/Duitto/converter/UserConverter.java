package com.Duitto.converter;

import com.Duitto.dto.UserDto;
import com.Duitto.model.CustomerRegistrationModel;
import com.Duitto.utility.MethodsUtility;

public class UserConverter {

    public static CustomerRegistrationModel dtoToEntity(UserDto userDto) {
        CustomerRegistrationModel user = new CustomerRegistrationModel();
        user.setIsCreatedOn(MethodsUtility.getCurrentTimestamp());
        user.setEnabled(false);
 
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
      
        user.setUserRole("USER");
        user.setIp(userDto.getIp());	
        return user;
    }

    public static UserDto entityToDto(CustomerRegistrationModel user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
 
        userDto.setUserRole(user.getUserRole());
        userDto.setIsCreatedOn(user.getIsCreatedOn());

        userDto.setEmail(user.getEmail());
        userDto.setIp(user.getIp());
        return userDto;
        }
       
        	
    

    public static UserDto entityToDtoCutomerBasic(CustomerRegistrationModel user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setUserRole(user.getUserRole());
        userDto.setIsCreatedOn(user.getIsCreatedOn());
        userDto.setEmail(user.getEmail());
        userDto.setIp(user.getIp());
        return userDto;
    }
}
