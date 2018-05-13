package com.testing.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class LogoutRequest {

@SerializedName("token")
@Expose
private Integer token;
@SerializedName("userId")
@Expose
private Integer userId;

/**
* No args constructor for use in serialization
* 
*/
public LogoutRequest() {
}

/**
* 
* @param token
* @param userId
*/
public LogoutRequest(Integer token, Integer userId) {
super();
this.token = token;
this.userId = userId;
}

public Integer getToken() {
return token;
}

public void setToken(Integer token) {
this.token = token;
}

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}




}