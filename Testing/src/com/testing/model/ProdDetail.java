package com.testing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProdDetail {

@SerializedName("productId")
@Expose
private Integer productId;
@SerializedName("productName")
@Expose
private String productName;
@SerializedName("productDescription")
@Expose
private String productDescription;
@SerializedName("comapny")
@Expose
private String comapny;
@SerializedName("price")
@Expose
private Double price;
@SerializedName("assignment")
@Expose
private Integer assignment;
@SerializedName("assignedby")
@Expose
private String assignedby;

/**
* No args constructor for use in serialization
* 
*/
public ProdDetail() {
}

/**
* 
* @param assignment
* @param price
* @param assignedby
* @param comapny
* @param productDescription
* @param productName
* @param productId
*/
public ProdDetail(Integer productId, String productName, String productDescription, String comapny, Double price, Integer assignment, String assignedby) {
super();
this.productId = productId;
this.productName = productName;
this.productDescription = productDescription;
this.comapny = comapny;
this.price = price;
this.assignment = assignment;
this.assignedby = assignedby;
}

public Integer getProductId() {
return productId;
}

public void setProductId(Integer productId) {
this.productId = productId;
}

public String getProductName() {
return productName;
}

public void setProductName(String productName) {
this.productName = productName;
}

public String getProductDescription() {
return productDescription;
}

public void setProductDescription(String productDescription) {
this.productDescription = productDescription;
}

public String getComapny() {
return comapny;
}

public void setComapny(String comapny) {
this.comapny = comapny;
}

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public Integer getAssignment() {
return assignment;
}

public void setAssignment(Integer assignment) {
this.assignment = assignment;
}

public String getAssignedby() {
return assignedby;
}

public void setAssignedby(String assignedby) {
this.assignedby = assignedby;
}


}