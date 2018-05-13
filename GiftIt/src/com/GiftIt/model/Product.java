package com.GiftIt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

@SerializedName("productID")
@Expose
private Integer productID;
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
@SerializedName("productLink")
@Expose
private String productLink;

/**
* No args constructor for use in serialization
* 
*/
public Product() {
}

/**
* 
* @param price
* @param comapny
* @param productDescription
* @param productName
* @param productID
* @param productLink
*/
public Product(Integer productID, String productName, String productDescription, String comapny, Double price, String productLink) {
super();
this.productID = productID;
this.productName = productName;
this.productDescription = productDescription;
this.comapny = comapny;
this.price = price;
this.productLink = productLink;
}

public Integer getProductID() {
return productID;
}

public void setProductID(Integer productID) {
this.productID = productID;
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

public String getProductLink() {
return productLink;
}

public void setProductLink(String productLink) {
this.productLink = productLink;
}

}