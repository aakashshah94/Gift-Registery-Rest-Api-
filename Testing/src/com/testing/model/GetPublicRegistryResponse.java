package com.testing.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetPublicRegistryResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("publicRegistry")
@Expose
private List<String> publicRegistry = null;

/**
* No args constructor for use in serialization
* 
*/
public GetPublicRegistryResponse() {
}

/**
* 
* @param publicRegistry
* @param error
* @param status
* @param errorcode
*/
public GetPublicRegistryResponse(Integer status, String error, Integer errorcode, List<String> publicRegistry) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.publicRegistry = publicRegistry;
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

public List<String> getPublicRegistry() {
return publicRegistry;
}

public void setPublicRegistry(List<String> publicRegistry) {
this.publicRegistry = publicRegistry;
}

}