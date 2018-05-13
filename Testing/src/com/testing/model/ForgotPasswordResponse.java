package com.testing.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ForgotPasswordResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("question")
@Expose
private Integer question;

/**
* No args constructor for use in serialization
* 
*/
public ForgotPasswordResponse() {
}

/**
* 
* @param error
* @param status
* @param question
* @param errorcode
*/
public ForgotPasswordResponse(Integer status, String error, Integer errorcode, Integer question) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.question = question;
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

public Integer getQuestion() {
return question;
}

public void setQuestion(Integer question) {
this.question = question;
}


}