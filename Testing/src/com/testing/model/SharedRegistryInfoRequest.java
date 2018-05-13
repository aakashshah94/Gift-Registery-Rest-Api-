package com.testing.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SharedRegistryInfoRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("userId")
@Expose
private int userId;
@SerializedName("email")
@Expose
private String email;



@SerializedName("registry")
@Expose
private String registry;

/**
* No args constructor for use in serialization
* 
*/
public SharedRegistryInfoRequest() {
}

/**
* 
* @param email
* @param token
* @param registry
*/
public SharedRegistryInfoRequest(String token, int userId, String email, String registry) {
super();
this.userId = userId;
this.token = token;
this.email = email;
this.registry = registry;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getRegistry() {
return registry;
}

public void setRegistry(String registry) {
this.registry = registry;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

}