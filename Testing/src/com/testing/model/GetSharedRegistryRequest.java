package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetSharedRegistryRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("email")
@Expose
private String email;

/**
* No args constructor for use in serialization
* 
*/
public GetSharedRegistryRequest() {
}

/**
* 
* @param email
* @param token
* @param userId
*/
public GetSharedRegistryRequest(String token, Integer userId, String email) {
super();
this.token = token;
this.userId = userId;
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

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}


}