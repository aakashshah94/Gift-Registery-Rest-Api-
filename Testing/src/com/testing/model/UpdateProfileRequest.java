package com.testing.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UpdateProfileRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("firstName")
@Expose
private String firstName;
@SerializedName("lastName")
@Expose
private String lastName;
@SerializedName("email")
@Expose
private String email;

/**
* No args constructor for use in serialization
* 
*/
public UpdateProfileRequest() {
}

/**
* 
* @param lastName
* @param email
* @param token
* @param userId
* @param firstName
*/
public UpdateProfileRequest(String token, Integer userId, String firstName, String lastName, String email) {
super();
this.token = token;
this.userId = userId;
this.firstName = firstName;
this.lastName = lastName;
this.email = email;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
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

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}


}