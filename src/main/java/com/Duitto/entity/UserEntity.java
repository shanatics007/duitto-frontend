package com.Duitto.entity;

public class UserEntity {

	private Long id;

	private String fullName;

	private String email;

	private long isCreatedOn;

	private String userRole;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
