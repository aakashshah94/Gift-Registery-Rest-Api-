package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetPasswordRequest {

@SerializedName("email")
@Expose
private String email;
@SerializedName("answer")
@Expose
private String answer;

/**
* No args constructor for use in serialization
* 
*/
public GetPasswordRequest() {
}

/**
* 
* @param email
* @param answer
*/
public GetPasswordRequest(String email, String answer) {
super();
this.email = email;
this.answer = answer;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getAnswer() {
return answer;
}

public void setAnswer(String answer) {
this.answer = answer;
}
}
