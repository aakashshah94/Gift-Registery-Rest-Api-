package com.testing.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UpdateProfileResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("firstName")
@Expose
private String firstName;
@SerializedName("lastName")
@Expose
private String lastName;

/**
* No args constructor for use in serialization
* 
*/
public UpdateProfileResponse() {
}

/**
* 
* @param lastName
* @param error
* @param status
* @param userId
* @param errorcode
* @param firstName
*/
public UpdateProfileResponse(Integer status, String error, Integer errorcode, Integer userId, String firstName, String lastName) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.userId = userId;
this.firstName = firstName;
this.lastName = lastName;
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

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

}