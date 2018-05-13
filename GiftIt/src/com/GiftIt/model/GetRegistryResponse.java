package com.GiftIt.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetRegistryResponse {

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
private List<String> registryName = null;

/**
* No args constructor for use in serialization
* 
*/
public GetRegistryResponse() {
}

/**
* 
* @param registryName
* @param error
* @param status
* @param errorcode
*/
public GetRegistryResponse(Integer status, String error, Integer errorcode, List<String> registryName) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.registryName = registryName;
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

public List<String> getRegistryName() {
return registryName;
}

public void setRegistryName(List<String> registryName) {
this.registryName = registryName;
}



}