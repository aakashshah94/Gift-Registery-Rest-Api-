package com.GiftIt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetRegistryRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("ownerId")
@Expose
private Integer ownerId;

/**
* No args constructor for use in serialization
* 
*/
public GetRegistryRequest() {
}

/**
* 
* @param token
* @param ownerId
*/
public GetRegistryRequest(String token, Integer ownerId) {
super();
this.token = token;
this.ownerId = ownerId;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public Integer getOwnerId() {
return ownerId;
}

public void setOwnerId(Integer ownerId) {
this.ownerId = ownerId;
}

}