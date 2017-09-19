package com.logui.models;

public class LoginModel {
	 private int sid; 
	  private String id; 
	  private String firstName; 
	  private String lastName; 
	  private String updatedAt; 

	  public int getSid(){
	  	return sid; 
	  }
	  public void setSid(int input){
	  	 this.sid = input;
	  }
	  public String getId(){
	  	return id; 
	  }
	  public void setId(String input){
	  	 this.id = input;
	  }
	  public String getFirstName(){
	  	return firstName; 
	  }
	  public void setFirstName(String input){
	  	 this.firstName = input;
	  }
	  public String getLastName(){
	  	return lastName; 
	  }
	  public void setLastName(String input){
	  	 this.lastName = input;
	  }
	  public String getUpdatedAt(){
	  	return updatedAt; 
	  }
	  public void setUpdatedAt(String input){
	  	 this.updatedAt = input;
	  }
}
