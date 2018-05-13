package com.giftit.jersey.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateRegistryRequest {

@SerializedName("ownerID")
@Expose
private Integer ownerID;
@SerializedName("registryName")
@Expose
private String registryName;
@SerializedName("private")
@Expose
private Boolean _private;

/**
* No args constructor for use in serialization
* 
*/
public CreateRegistryRequest() {
}

/**
* 
* @param registryName
* @param ownerID
* @param _private
*/
public CreateRegistryRequest(Integer ownerID, String registryName, Boolean _private) {
super();
this.ownerID = ownerID;
this.registryName = registryName;
this._private = _private;
}

public Integer getOwnerID() {
return ownerID;
}

public void setOwnerID(Integer ownerID) {
this.ownerID = ownerID;
}

public String getRegistryName() {
return registryName;
}

public void setRegistryName(String registryName) {
this.registryName = registryName;
}

public Boolean getPrivate() {
return _private;
}

public void setPrivate(Boolean _private) {
this._private = _private;
}

}