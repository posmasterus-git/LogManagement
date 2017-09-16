package com.logui.models;


public class LogGroupModel{
	  private int sid; 
	  private String id; 
	  private int masterSid; 
	  private String name; 
	  private String description; 
	  private int isActive; 
	  private String updatedAt; 
	  private String updatedBy; 

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
	  public int getMasterSid(){
	  	return masterSid; 
	  }
	  public void setMasterSid(int input){
	  	 this.masterSid = input;
	  }
	  public String getName(){
	  	return name; 
	  }
	  public void setName(String input){
	  	 this.name = input;
	  }
	  public String getDescription(){
	  	return description; 
	  }
	  public void setDescription(String input){
	  	 this.description = input;
	  }
	  public int getIsActive(){
	  	return isActive; 
	  }
	  public void setIsActive(int input){
	  	 this.isActive = input;
	  }
	  public String getUpdatedAt(){
	  	return updatedAt; 
	  }
	  public void setUpdatedAt(String input){
	  	 this.updatedAt = input;
	  }
	  public String getUpdatedBy(){
	  	return updatedBy; 
	  }
	  public void setUpdatedBy(String input){
	  	 this.updatedBy = input;
	  }
}
  