package com.Duitto.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seqAuth", initialValue=133244)
@Table(name="sh_authentication_forgotpass")
public class AuthenticationForgotpass {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAuth")
	@Column(name="auth_id")
	private long authId;

	@Column(name="cust_id")
	private long custId;
	
	@Column(name="auth_key")
	private String authKey;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="is_active")
	private int isActive;

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey2) {
		this.authKey = authKey2;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}
}
