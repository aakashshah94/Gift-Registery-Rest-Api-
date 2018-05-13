package com.testing.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

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

	public int getStatus() {
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

	public SignUpResponse(Integer status, String error, String errorcode, String token) {
		super();
		this.status = status;
		this.error = error;
		this.errorcode = errorcode;
		this.token = token;
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

	
}