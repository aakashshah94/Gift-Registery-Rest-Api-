
package com.giftit.jersey.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupRequest {

@SerializedName("firstName")
@Expose
private String firstName;
@SerializedName("lastName")
@Expose
private String lastName;
@SerializedName("email")
@Expose
private String email;
@SerializedName("password")
@Expose
private String password;
@SerializedName("question")
@Expose
private Integer question;
@SerializedName("answer")
@Expose
private String answer;

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public Integer getQuestion() {
return question;
}

public void setQuestion(Integer question) {
this.question = question;
}

public String getAnswer() {
return answer;
}

public void setAnswer(String answer) {
this.answer = answer;
}

}