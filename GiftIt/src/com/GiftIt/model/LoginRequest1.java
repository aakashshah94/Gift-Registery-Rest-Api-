package com.GiftIt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest1 {
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
		public LoginRequest1() {
		}

		/**
		*
		* @param userName
		* @param password
		*/
		public LoginRequest1(String userName, String password) {
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


