package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegistryDetailsRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("ownerId")
@Expose
private int ownerId;
public int getOwnerId() {
	return ownerId;
}

public void setOwnerId(int ownerId) {
	this.ownerId = ownerId;
}

@SerializedName("registryName")
@Expose
private String registryName;

/**
* No args constructor for use in serialization
* 
*/
public RegistryDetailsRequest() {
}

/**
* 
* @param registryName
* @param token
*/
public RegistryDetailsRequest(String token,int ownerId, String registryName) {
super();
this.token = token;
this.ownerId=ownerId;
this.registryName = registryName;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public String getRegistryName() {
return registryName;
}

public void setRegistryName(String registryName) {
this.registryName = registryName;
}


}