package com.logui.models;



public class UserList {
	 private int sid; 
	  private String id; 
	  private int masterSid; 
	  private String firstName; 
	  private String lastName; 
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
	  public String getFirstName(){
	  	return firstName; 
	  }
	  public void setFirstName(String input){
	  	 this.firstName = input;
	  }
	  public String getLastName(){
	  	return lastName; 
	  }
	  public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setLastName(String input){
	  	 this.lastName = input;
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
	
	  
	  

	public UserList(java.lang.String id, int masterSid, java.lang.String firstName, java.lang.String lastName,
			int isActive, java.lang.String updatedAt, java.lang.String updatedBy) {
		super();
		this.id = id;
		this.masterSid = masterSid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}}
