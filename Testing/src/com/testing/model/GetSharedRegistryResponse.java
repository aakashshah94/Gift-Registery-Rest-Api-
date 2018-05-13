package com.testing.model;
import java.util.List;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetSharedRegistryResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("sharedRegistry")
@Expose
@Valid
private List<String> sharedRegistry = null;

/**
* No args constructor for use in serialization
* 
*/
public GetSharedRegistryResponse() {
}

/**
* 
* @param sharedRegistry
* @param error
* @param status
* @param errorcode
*/
public GetSharedRegistryResponse(Integer status, String error, Integer errorcode, List<String> sharedRegistry) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.sharedRegistry = sharedRegistry;
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

public List<String> getSharedRegistry() {
return sharedRegistry;
}

public void setSharedRegistry(List<String> sharedRegistry) {
this.sharedRegistry = sharedRegistry;
}

}