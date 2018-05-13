package com.giftit.jersey.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AddProductRequest {

@SerializedName("productName")
@Expose
private String productName;
@SerializedName("prodctDesc")
@Expose
private String prodctDesc;
@SerializedName("commpany")
@Expose
private String commpany;
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
public AddProductRequest() {
}

/**
* 
* @param price
* @param commpany
* @param prodctDesc
* @param productName
* @param productLink
*/
public AddProductRequest(String productName, String prodctDesc, String commpany, Double price, String productLink) {
super();
this.productName = productName;
this.prodctDesc = prodctDesc;
this.commpany = commpany;
this.price = price;
this.productLink = productLink;
}

public String getProductName() {
return productName;
}

public void setProductName(String productName) {
this.productName = productName;
}

public String getProdctDesc() {
return prodctDesc;
}

public void setProdctDesc(String prodctDesc) {
this.prodctDesc = prodctDesc;
}

public String getCommpany() {
return commpany;
}

public void setCommpany(String commpany) {
this.commpany = commpany;
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