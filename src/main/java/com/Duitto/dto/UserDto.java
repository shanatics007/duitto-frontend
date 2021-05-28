package com.Duitto.dto;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto {

    private Long id;

    private String ip;



    private String fullName;

    private String email;

    private long isCreatedOn;

    private boolean isEnabled;

    private String userRole;

    public UserDto() {
    }

    public UserDto(Long id, String ip, String fullName,  String email, String mobileNumber,  long isCreatedOn, boolean isEnabled, String userRole) {
        this.id = id;
        this.ip = ip;
       
      
        this.fullName = fullName;
       
        this.email = email;
       

        this.isCreatedOn = isCreatedOn;
        this.isEnabled = isEnabled;
        this.userRole = userRole;
    }


    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

  


  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIsCreatedOn() {
        return isCreatedOn;
    }

    public void setIsCreatedOn(long isCreatedOn) {
        this.isCreatedOn = isCreatedOn;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
