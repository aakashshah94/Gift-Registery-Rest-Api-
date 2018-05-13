package com.testing.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AssignmentRequest {
@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("token")
@Expose
private String token;

@SerializedName("registryName")
@Expose
private String registryName;
@SerializedName("productId")
@Expose
private Integer productId;
@SerializedName("assignedBy")
@Expose
private String assignedBy;

/**
* No args constructor for use in serialization
* 
*/
public AssignmentRequest() {
}

/**
* 
* @param registryName
* @param assignedBy
* @param productId
*/
public AssignmentRequest(Integer UserId, String token, String registryName, Integer productId, String assignedBy) {
super();
this.userId = UserId;
this.token = token;
this.registryName = registryName;
this.productId = productId;
this.assignedBy = assignedBy;
}

public String getRegistryName() {
return registryName;
}

public void setRegistryName(String registryName) {
this.registryName = registryName;
}

public Integer getProductId() {
return productId;
}

public void setProductId(Integer productId) {
this.productId = productId;
}

public String getAssignedBy() {
return assignedBy;
}

public void setAssignedBy(String assignedBy) {
this.assignedBy = assignedBy;
}
public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}


}