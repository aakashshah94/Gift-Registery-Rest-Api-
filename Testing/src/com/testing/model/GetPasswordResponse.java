package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetPasswordResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("password")
@Expose
private String password;

/**
* No args constructor for use in serialization
* 
*/
public GetPasswordResponse() {
}

/**
* 
* @param error
* @param status
* @param errorcode
* @param password
*/
public GetPasswordResponse(Integer status, String error, Integer errorcode, String password) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.password = password;
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

public Integer getErrorcode() {
return errorcode;
}

public void setErrorcode(Integer errorcode) {
this.errorcode = errorcode;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}


}