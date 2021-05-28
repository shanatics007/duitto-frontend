package com.Duitto.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq", initialValue = 111313)
@Table(name = "sh_customer")
public class CustomerRegistrationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "ip")
	private String ip;

	@Column(name = "full_name")
	private String fullName;

	@Override
	public String toString() {
		return "CustomerRegistrationModel [id=" + id + ", ip=" + ip + ", fullName=" + fullName + ", email=" + email
				+ ", isCreatedOn=" + isCreatedOn + ", isEnabled=" + isEnabled + ", userRole=" + userRole + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "is_created_on")
	private long isCreatedOn;

	@Column(name = "is_enabled", columnDefinition = "boolean default false")
	private boolean isEnabled;

	@Column(name = "user_role")
	private String userRole;

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

	public long getIsCreatedOn() {
		return isCreatedOn;
	}

	public void setIsCreatedOn(long isCreatedOn) {
		this.isCreatedOn = isCreatedOn;
	}

}
