package com.GiftIt.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DeleteItemResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;

/**
* No args constructor for use in serialization
* 
*/
public DeleteItemResponse() {
}

/**
* 
* @param error
* @param status
* @param errorcode
*/
public DeleteItemResponse(Integer status, String error, Integer errorcode) {
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

public Integer getErrorcode() {
return errorcode;
}

public void setErrorcode(Integer errorcode) {
this.errorcode = errorcode;
}

}