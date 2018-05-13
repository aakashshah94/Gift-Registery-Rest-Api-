package com.testing.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistryDetailsResponse {

@SerializedName("status")
@Expose
private Integer status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("errorcode")
@Expose
private Integer errorcode;
@SerializedName("sharedWith")
@Expose
private List<String> sharedWith = null;
@SerializedName("productsDetails")
@Expose

private List<ProductsDetail> productsDetails = null;

/**
* No args constructor for use in serialization
* 
*/
public RegistryDetailsResponse() {
}

/**
* 
* @param productsDetails
* @param error
* @param sharedWith
* @param status
* @param errorcode
*/
public RegistryDetailsResponse(Integer status, String error, Integer errorcode, List<String> sharedWith, List<ProductsDetail> productsDetails) {
super();
this.status = status;
this.error = error;
this.errorcode = errorcode;
this.sharedWith = sharedWith;
this.productsDetails = productsDetails;
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

public List<String> getSharedWith() {
return sharedWith;
}

public void setSharedWith(List<String> sharedWith) {
this.sharedWith = sharedWith;
}

public List<ProductsDetail> getProductsDetails() {
return productsDetails;
}

public void setProductsDetails(List<ProductsDetail> productsDetails) {
this.productsDetails = productsDetails;
}


}