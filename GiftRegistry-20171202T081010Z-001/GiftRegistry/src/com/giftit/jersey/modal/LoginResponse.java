package com.giftit.jersey.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

	@SerializedName("status")
	@Expose
	private Integer status;
	@SerializedName("error")
	@Expose
	private String error;
	@SerializedName("errorcode")
	@Expose
	private String errorcode;
	@SerializedName("token")
	@Expose
	private String token;
	@SerializedName("firstName")
	@Expose
	private String firstName;
	
	@SerializedName("userId")
	@Expose
	private int userId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getStatus() {
	return status;
	}

	public void setStatus(Integer status) {
	this.status = status;
	}

	public String getError() {
	return error;
	}

	public void setError(String error) {
	this.error = error;
	}

	public String getErrorcode() {
	return errorcode;
	}

	public void setErrorcode(String errorcode) {
	this.errorcode = errorcode;
	}

	public String getToken() {
	return token;
	}

	public void setToken(String token) {
	this.token = token;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}