package com.testing.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorCode")
@Expose
private Integer errorCode;

/**
* No args constructor for use in serialization
* 
*/
public LogoutResponse() {
}

/**
* 
* @param error
* @param status
* @param errorCode
*/
public LogoutResponse(Integer status, String error, Integer errorCode) {
super();
this.status = status;
this.error = error;
this.errorCode = errorCode;
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

public Integer getErrorCode() {
return errorCode;
}

public void setErrorCode(Integer errorCode) {
this.errorCode = errorCode;
}


}