package com.giftit.jersey.modal;


	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	public class LoginRequest {
	    @SerializedName("userName")
	    @Expose
	    private String userName;
	    @SerializedName("password")
	    @Expose
	    private String password;

	    /**
	    * No args constructor for use in serialization
	    *
	    */
	    public LoginRequest() {
	    }

	    /**
	    *
	    * @param userName
	    * @param password
	    */
	    public LoginRequest(String userName, String password) {
	    super();
	    this.userName = userName;
	    this.password = password;
	    }

	    public String getUserName() {
	    return userName;
	    }

	    public void setUserName(String userName) {
	    this.userName = userName;
	    }

	    public String getPassword() {
	    return password;
	    }

	    public void setPassword(String password) {
	    this.password = password;
	    }


	}

