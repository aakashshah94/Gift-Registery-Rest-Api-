package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetPublicRegistryRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("userId")
@Expose
private Integer userId;

/**
* No args constructor for use in serialization
* 
*/
public GetPublicRegistryRequest() {
}

/**
* 
* @param token
* @param userId
*/
public GetPublicRegistryRequest(String token, Integer userId) {
super();
this.token = token;
this.userId = userId;
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



}