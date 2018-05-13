package com.giftit.jersey.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateRegistryResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private String errorcode;

/**
* No args constructor for use in serialization
* 
*/
public CreateRegistryResponse() {
}

/**
* 
* @param error
* @param status
* @param errorcode
*/
public CreateRegistryResponse(Integer status, String error, String errorcode) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
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

public String getErrorcode() {
return errorcode;
}

public void setErrorcode(String errorcode) {
this.errorcode = errorcode;
}


}