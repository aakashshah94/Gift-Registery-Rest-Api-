package com.GiftIt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductsDetail {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("productName")
@Expose
private String productName;
@SerializedName("productDescription")
@Expose
private String productDescription;
@SerializedName("company")
@Expose
private String company;
@SerializedName("price")
@Expose
private Double price;
@SerializedName("assignedBy")
@Expose
private String assignedBy;

/**
* No args constructor for use in serialization
* 
*/
public ProductsDetail() {
}

/**
* 
* @param id
* @param price
* @param productDescription
* @param company
* @param assignedBy
* @param productName
*/
public ProductsDetail(Integer id, String productName, String productDescription, String company, Double price, String assignedBy) {
super();
this.id = id;
this.productName = productName;
this.productDescription = productDescription;
this.company = company;
this.price = price;
this.assignedBy = assignedBy;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
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

public String getCompany() {
return company;
}

public void setCompany(String company) {
this.company = company;
}

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public String getAssignedBy() {
return assignedBy;
}

public void setAssignedBy(String assignedBy) {
this.assignedBy = assignedBy;
}


}