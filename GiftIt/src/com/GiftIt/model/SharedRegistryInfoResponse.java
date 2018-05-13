package com.GiftIt.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SharedRegistryInfoResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("registryName")
@Expose
private String registryName;
@SerializedName("owner")
@Expose
private String owner;
@SerializedName("prodDetails")
@Expose
private List<ProdDetail> prodDetails = null;

/**
* No args constructor for use in serialization
* 
*/
public SharedRegistryInfoResponse() {
}

/**
* 
* @param prodDetails
* @param registryName
* @param error
* @param status
* @param owner
* @param errorcode
*/
public SharedRegistryInfoResponse(Integer status, String error, Integer errorcode, String registryName, String owner, List<ProdDetail> prodDetails) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.registryName = registryName;
this.owner = owner;
this.prodDetails = prodDetails;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}

public String getError() {
return error;
}

public void setError(String error) {
this.error = error;
}

public Integer getErrorcode() {
return errorcode;
}

public void setErrorcode(Integer errorcode) {
this.errorcode = errorcode;
}

public String getRegistryName() {
return registryName;
}

public void setRegistryName(String registryName) {
this.registryName = registryName;
}

public String getOwner() {
return owner;
}

public void setOwner(String owner) {
this.owner = owner;
}

public List<ProdDetail> getProdDetails() {
return prodDetails;
}

public void setProdDetails(List<ProdDetail> prodDetails) {
this.prodDetails = prodDetails;
}

}