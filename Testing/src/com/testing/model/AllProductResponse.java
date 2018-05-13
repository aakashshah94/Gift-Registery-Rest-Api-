package com.testing.model;

import java.util.List;

import javax.validation.Valid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllProductResponse {

@SerializedName("length")
@Expose
private Integer length;
@SerializedName("status")
@Expose
private Integer status;
@SerializedName("Error")
@Expose
private String error;
@SerializedName("ErrorCode")
@Expose
private String errorCode;
@SerializedName("products")
@Expose
@Valid
private List<Product> products = null;

/**
* No args constructor for use in serialization
* 
*/
public AllProductResponse() {
}

/**
* 
* @param error
* @param status
* @param errorCode
* @param length
* @param products
*/
public AllProductResponse(Integer length, Integer status, String error, String errorCode, List<Product> products) {
super();
this.length = length;
this.status = status;
this.error = error;
this.errorCode = errorCode;
this.products = products;
}

public Integer getLength() {
return length;
}

public void setLength(Integer length) {
this.length = length;
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

public String getErrorCode() {
return errorCode;
}

public void setErrorCode(String errorCode) {
this.errorCode = errorCode;
}

public List<Product> getProducts() {
return products;
}

public void setProducts(List<Product> products) {
this.products = products;
}

}
