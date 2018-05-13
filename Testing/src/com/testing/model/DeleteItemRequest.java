package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteItemRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("productId")
@Expose
private Integer productId;

/**
* No args constructor for use in serialization
* 
*/
public DeleteItemRequest() {
}

/**
* 
* @param token
* @param userId
* @param productId
*/
public DeleteItemRequest(String token, Integer userId, Integer productId) {
super();
this.token = token;
this.userId = userId;
this.productId = productId;
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

public Integer getProductId() {
return productId;
}

public void setProductId(Integer productId) {
this.productId = productId;
}

}