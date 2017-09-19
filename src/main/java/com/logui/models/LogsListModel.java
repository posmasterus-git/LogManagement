package com.logui.models;

public class LogsListModel {
	
	 private int sid; 
	  private int logGroupSid; 
	  private int userSid; 
	  private String logType; 
	  private String category; 
	  private String module; 
	  private String functionId; 
	  private String testCode; 
	  private String tags; 
	  private String message; 
	  private String filename; 
	  private int line; 
	  private int location; 
	  private String ref01; 
	  private String ref02; 
	  private String updatedAt; 
	  private String updatedBy; 

	  public int getSid(){
	  	return sid; 
	  }
	  public void setSid(int input){
	  	 this.sid = input;
	  }
	  public int getLogGroupSid(){
	  	return logGroupSid; 
	  }
	  public void setLogGroupSid(int input){
	  	 this.logGroupSid = input;
	  }
	  public int getUserSid(){
	  	return userSid; 
	  }
	  public void setUserSid(int input){
	  	 this.userSid = input;
	  }
	  public String getLogType(){
	  	return logType; 
	  }
	  public void setLogType(String input){
	  	 this.logType = input;
	  }
	  public String getCategory(){
	  	return category; 
	  }
	  public void setCategory(String input){
	  	 this.category = input;
	  }
	  public String getModule(){
	  	return module; 
	  }
	  public void setModule(String input){
	  	 this.module = input;
	  }
	  public String getFunctionId(){
	  	return functionId; 
	  }
	  public void setFunctionId(String input){
	  	 this.functionId = input;
	  }
	  public String getTestCode(){
	  	return testCode; 
	  }
	  public void setTestCode(String input){
	  	 this.testCode = input;
	  }
	  public String getTags(){
	  	return tags; 
	  }
	  public void setTags(String input){
	  	 this.tags = input;
	  }
	  public String getMessage(){
	  	return message; 
	  }
	  public void setMessage(String input){
	  	 this.message = input;
	  }
	  public String getFilename(){
	  	return filename; 
	  }
	  public void setFilename(String input){
	  	 this.filename = input;
	  }
	  public int getLine(){
	  	return line; 
	  }
	  public void setLine(int input){
	  	 this.line = input;
	  }
	  public int getLocation(){
	  	return location; 
	  }
	  public void setLocation(int input){
	  	 this.location = input;
	  }
	  public String getRef01(){
	  	return ref01; 
	  }
	  public void setRef01(String input){
	  	 this.ref01 = input;
	  }
	  public String getRef02(){
	  	return ref02; 
	  }
	  public void setRef02(String input){
	  	 this.ref02 = input;
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
