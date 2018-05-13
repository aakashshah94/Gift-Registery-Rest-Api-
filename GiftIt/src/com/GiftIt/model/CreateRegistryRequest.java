package com.GiftIt.model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateRegistryRequest {

@SerializedName("token")
@Expose
private String token;
@SerializedName("ownerId")
@Expose
private Integer ownerId;
@SerializedName("registryName")
@Expose
private String registryName;
@SerializedName("pp")
@Expose
private Integer pp;
@SerializedName("productId")
@Expose

private List<Integer> productId = null;
@SerializedName("sharedId")
@Expose

private List<String> sharedId = null;

/**
* No args constructor for use in serialization
* 
*/
public CreateRegistryRequest() {
}

/**
* 
* @param registryName
* @param token
* @param ownerId
* @param sharedId
* @param pp
* @param productId
*/
public CreateRegistryRequest(String token, Integer ownerId, String registryName, Integer pp, List<Integer> productId, List<String> sharedId) {
super();
this.token = token;
this.ownerId = ownerId;
this.registryName = registryName;
this.pp = pp;
this.productId = productId;
this.sharedId = sharedId;
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

public String getRegistryName() {
return registryName;
}

public void setRegistryName(String registryName) {
this.registryName = registryName;
}

public Integer getPp() {
return pp;
}

public void setPp(Integer pp) {
this.pp = pp;
}

public List<Integer> getProductId() {
return productId;
}

public void setProductId(List<Integer> productId) {
this.productId = productId;
}

public List<String> getSharedId() {
return sharedId;
}

public void setSharedId(List<String> sharedId) {
this.sharedId = sharedId;
}


}