package com.logui.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.logui.models.LogGroupModel;
import com.logui.models.LogTypeModel;
import com.logui.models.UserList;
@Controller
public class LogTypeViewController {
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	public List<LogTypeModel> listlogroupInfo(String username){
		
		LoginController logcont = new LoginController();
		int mastersid = logcont.getSID(username);
		
		
		String inline = "";
		LogTypeModel loggrouplistobj = null;
		List<LogTypeModel> listoflogtype= new ArrayList<LogTypeModel>();
		
		try
		{
			URL url = new URL("http://54.153.82.170:4000/atest/api/logging_code_dict/search?master_sid="+mastersid);
			//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			//Use the connect method to create the connection bridge
			conn.connect();
			//Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			
			//Iterating condition to if response code is not 200 then throw a runtime exception
			//else continue the actual process of getting the JSON data
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				
				sc.close();
			}
			
			JSONParser parse = new JSONParser();
			JSONObject obj = (JSONObject)parse.parse(inline);
			JSONArray jsonarr_1 = (JSONArray) obj.get("data");
			for(int i=0;i<jsonarr_1.size();i++)
			{
				loggrouplistobj=new LogTypeModel();
				JSONObject jObj = (JSONObject)jsonarr_1.get(i);
				
				
				if(((String)jObj.get("main_code")).equals("001"))
				{
				
					loggrouplistobj.setSid(((Long) jObj.get("sid")).intValue());
					loggrouplistobj.setMasterSid(((Long) jObj.get("master_sid")).intValue());
					loggrouplistobj.setValue(((Long) jObj.get("value")).intValue());
					loggrouplistobj.setMainCode((String)jObj.get("main_code"));
					loggrouplistobj.setSubCode((String)jObj.get("sub_code"));
					loggrouplistobj.setName((String)jObj.get("name"));
					loggrouplistobj.setComment((String)jObj.get("comment"));
					loggrouplistobj.setModule((String)jObj.get("module"));
					loggrouplistobj.setRef01((String)jObj.get("ref01"));
					loggrouplistobj.setRef02((String)jObj.get("ref02"));
					
					loggrouplistobj.setUsedCode((String)jObj.get("used_code"));
					System.out.println((String)jObj.get("name"));
					loggrouplistobj.setDescription((String)jObj.get("description"));
					loggrouplistobj.setIsActive(((Long) jObj.get("is_active")).intValue());
					loggrouplistobj.setUpdatedAt((String)jObj.get("updated_at"));
					loggrouplistobj.setUpdatedBy((String)jObj.get("updated_by"));
					listoflogtype.add(loggrouplistobj);
				}
				
				
		       
				}
				
			
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listoflogtype;
	}
	
	
public List<LogTypeModel> listlogroupInfo(int sid){
		
		
		
		
		String inline = "";
		LogTypeModel loggrouplistobj = null;
		List<LogTypeModel> listoflogtype= new ArrayList<LogTypeModel>();
		
		try
		{
			URL url = new URL("http://54.153.82.170:4000/atest/api/logging_code_dict/search?sid="+sid);
			//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			//Use the connect method to create the connection bridge
			conn.connect();
			//Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			
			//Iterating condition to if response code is not 200 then throw a runtime exception
			//else continue the actual process of getting the JSON data
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				
				sc.close();
			}
			
			JSONParser parse = new JSONParser();
			JSONObject obj = (JSONObject)parse.parse(inline);
			JSONArray jsonarr_1 = (JSONArray) obj.get("data");
			for(int i=0;i<jsonarr_1.size();i++)
			{
				loggrouplistobj=new LogTypeModel();
				JSONObject jObj = (JSONObject)jsonarr_1.get(i);
				
				
				if(((String)jObj.get("main_code")).equals("001"))
				{
				
					loggrouplistobj.setSid(((Long) jObj.get("sid")).intValue());
					loggrouplistobj.setMasterSid(((Long) jObj.get("master_sid")).intValue());
					loggrouplistobj.setValue(((Long) jObj.get("value")).intValue());
					loggrouplistobj.setMainCode((String)jObj.get("main_code"));
					loggrouplistobj.setSubCode((String)jObj.get("sub_code"));
					loggrouplistobj.setName((String)jObj.get("name"));
					loggrouplistobj.setComment((String)jObj.get("comment"));
					loggrouplistobj.setModule((String)jObj.get("module"));
					loggrouplistobj.setRef01((String)jObj.get("ref01"));
					loggrouplistobj.setRef02((String)jObj.get("ref02"));
					
					loggrouplistobj.setUsedCode((String)jObj.get("used_code"));
					System.out.println((String)jObj.get("name"));
					loggrouplistobj.setDescription((String)jObj.get("description"));
					loggrouplistobj.setIsActive(((Long) jObj.get("is_active")).intValue());
					loggrouplistobj.setUpdatedAt((String)jObj.get("updated_at"));
					loggrouplistobj.setUpdatedBy((String)jObj.get("updated_by"));
					listoflogtype.add(loggrouplistobj);
				}
				
				
		       
				}
				
			
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listoflogtype;
	}
	

	private String sendPost(String subcode,String name,String description, String active, String master_username) throws Exception {
		
		LoginController logcont = new LoginController();
		int mastersid = logcont.getSID(master_username);
	
	String url = "http://54.153.82.170:4000/atest/api/logging_code_dict/";
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	int flag= -1;
	//add reuqest header
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	con.setRequestProperty("Accept", "application/json");
	con.setRequestProperty("Content-type", "application/json");
	if(active.equals(","+"on"))
			{
					flag= 1;
			}
	else
	{
		flag=0;
	}
	String urlParameters = String.format("{\"req_data_length\":1,\"req_data\":[{\"master_sid\":\"%d\", \"main_code\":\"001\", \"sub_code\":\"%s\",\"name\":\"%s\",\"description\":\"%s\", \"value\":\"12\", \"seq_order\":\"4561\",\"module\":\"kaushik\",\"is_active\":\"%d\", \"updated_by\":\"%s\", \"comment\":\"kaushik\",\"ref_01\":\"ref_02\",\"used_code\":\"1\"}] }",mastersid,subcode,name,description, flag, master_username);
	//String urlParameters= "{\"req_data_length\":1,\"req_data\":[{\"id\":"+userid+",\"master_sid\":\"21\",\"first_name\":"+firstname+",\"last_name\":"+lastname+",\"is_active\":\"0\",\"updated_by\":\"ishita\"}] }";
	

	// Send post request
	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(urlParameters);
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

	//print result
	System.out.println(response.toString());
	return response.toString();

}

	
public String edit(String Username, String active, int sid) throws Exception {
		
		String subcode=null, comment = null, desc = null, updatedby=null, maincode=null, module=null, name=null, ref01=null, ref02=null, usedcode=null;
		int seqorder=-1;
		int value= -1;
		int mastersid = 0,flag= -1;; 
		
		LoginController logcont = new LoginController();
		mastersid = logcont.getSID(Username);
	
	ArrayList<LogTypeModel> loglist = (ArrayList<LogTypeModel>) listlogroupInfo(sid);
	
	for(LogTypeModel ulist : loglist)
	{
		comment=ulist.getComment();
		subcode = ulist.getSubCode();
		desc = ulist.getDescription();
		maincode= ulist.getMainCode();
		ulist.getMasterSid();
		module = ulist.getModule();
		name = ulist.getName();
		ref01 = ulist.getRef01();
		ref02 = ulist.getRef02();
		seqorder = ulist.getSeqOrder();
		//sid = ulist.getSid();
		usedcode = ulist.getUsedCode();
		value = ulist.getValue();
		
		//active = ulist.getIsActive();
		mastersid = ulist.getMasterSid();
		updatedby = ulist.getUpdatedBy();
		
	}
	if(active.equals("True"))
	{
				flag= 0;
	}
else
{
	flag=1;
}
	
	String url = "http://54.153.82.170:4000/atest/api/logging_code_dict/";
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
	//add reuqest header
	con.setRequestMethod("PUT");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	con.setRequestProperty("Accept", "application/json");
	con.setRequestProperty("Content-type", "application/json");
	
	String urlParameters = String.format("{\"req_data_length\":1, \"req_data\":[{\"sid\": %d,\"master_sid\": %d,\"main_code\": \"%s\",\"sub_code\": \"%s\",\"name\": \"%s\",\"description\": \"%s\",\"value\": %d,\"seq_order\": %d,\"module\": \"%s\",\"is_active\": %d,\"updated_by\": \"%s\",\"comment\": \"%s\",\"ref_01\": \"%s\",\"ref_02\": \" %s\",\"used_code\": \"%s\"}]}",sid,mastersid,maincode, subcode, name, desc, value, seqorder, module, flag, updatedby, comment, ref01, ref02, usedcode);
	//String urlParameters= "{\"req_data_length\":1,\"req_data\":[{\"id\":"+userid+",\"master_sid\":\"21\",\"first_name\":"+firstname+",\"last_name\":"+lastname+",\"is_active\":\"0\",\"updated_by\":\"ishita\"}] }";
	

	// Send post request
	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(urlParameters);
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'PUT' request to URL : " + url);
	System.out.println("PUT parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);
	
	if(responseCode!=200){
		return null;
	} 
	
	else{
	
	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

	//print result
	System.out.println(response.toString());
	return response.toString();
	}

}
	
	
	
	@RequestMapping(value = "/logTypeView", method = RequestMethod.POST )
	public String  editUserModelView(Model model,@RequestParam String name,@RequestParam String subcode,@RequestParam String description, @RequestParam String active, @RequestParam String username) {
		String response = null;
		try {
			response = sendPost(subcode, name, description, active, username);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("logTypeView");
		//("index","response", response);
		
		
   	 return "redirect:/logTypeView?username="+username;
	}
	
	@RequestMapping("/logTypeView")
    public ModelAndView  logView(@RequestParam("username") String username) {
	
		List<LogTypeModel> logtypelist = listlogroupInfo(username);
		ModelAndView model = new ModelAndView("logTypeView","logtypelist", logtypelist);
		
		
   	 return model;
    }
	
	@RequestMapping("/addLogType")
    public ModelAndView  addlogTypeView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("addLogType","message", message);
		
		//model.addObject("userlist", userlist);
   	 return model;
    }
	
	
	@RequestMapping(value="/editLogType", method = RequestMethod.GET)
    public String  editLogtype(Model model,@RequestParam String username, @RequestParam String active, @RequestParam int id) {
		String response = null;
		System.out.println("++++++++++++_________________________ACTIVE_____________________++++++++++++"+active);
		try {
			
			response = edit(username, active, id);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		if(response!=null){
			model.addAttribute("editLogtype");
			
			System.out.println(response);
			return "redirect:/logTypeView?username="+username;
			
		}
		else
		{
			return "redirect:/logTypeView?username="+username;
		}
		
		
	}
	
}
