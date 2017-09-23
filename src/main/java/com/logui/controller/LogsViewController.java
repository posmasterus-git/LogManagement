package com.logui.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.logui.models.LogGroupModel;
import com.logui.models.LogsListModel;
import com.logui.models.UserList;
import com.logui.controller.*;

@Controller
public class LogsViewController {
	
	
	
	
private final String USER_AGENT = "Mozilla/5.0";

	private int sid = -1;

EditLogGroupController editloglist = new EditLogGroupController();

public List<LogGroupModel> listlogroupInfo(String logroupid){
	
	
	String inline = "";
	LogGroupModel loggrouplistobj = null;
	List<LogGroupModel> listofloggroups= new ArrayList<LogGroupModel>();
	
	try
	{
		URL url = new URL("http://54.153.82.170:4000/atest/api/logging_log_group/id/"+logroupid);
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
			JSONObject jObj = (JSONObject)jsonarr_1.get(i);
			
			
			loggrouplistobj=new LogGroupModel();
            
			loggrouplistobj.setSid(((Long) jObj.get("sid")).intValue());
			loggrouplistobj.setId((String)jObj.get("id"));
			loggrouplistobj.setMasterSid(((Long) jObj.get("master_sid")).intValue());
			loggrouplistobj.setName((String)jObj.get("name"));
			System.out.println((String)jObj.get("name"));
			loggrouplistobj.setDescription((String)jObj.get("description"));
			loggrouplistobj.setIsActive(((Long) jObj.get("is_active")).intValue());
			loggrouplistobj.setUpdatedAt((String)jObj.get("updated_at"));
			loggrouplistobj.setUpdatedBy((String)jObj.get("updated_by"));
            listofloggroups.add(loggrouplistobj);
	       
			}
			
		
		//Disconnect the HttpURLConnection stream
		conn.disconnect();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return listofloggroups;
}




	public List<LogsListModel> getlistLogsInfo(String id){
		int sid=-1;
		
		ArrayList<LogGroupModel> lglist = (ArrayList<LogGroupModel>) listlogroupInfo(id);
		
		for(LogGroupModel logrouplist : lglist)
		{
			sid = logrouplist.getSid();
		}
		String inline = "";
		LogsListModel logslistobj = null;
		List<LogsListModel> listoflogs= new ArrayList<LogsListModel>();
		
		try
		{
			URL url = new URL("http://54.153.82.170:4000/atest/api/logging_log/search/"+sid);
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
				
				//Close the stream when reading the data has been finished
				sc.close();
			}
			
			//JSONParser reads the data from string object and break each data into key value pairs
			JSONParser parse = new JSONParser();
			//Type caste the parsed json data in json object
			JSONObject obj = (JSONObject)parse.parse(inline);
			//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			JSONArray jsonarr_1 = (JSONArray) obj.get("data");
			//Get data for Results array
			for(int i=0;i<jsonarr_1.size();i++)
			{
				//Store the JSON objects in an array
				//Get the index of the JSON object and print the values as per the index
				JSONObject jObj = (JSONObject)jsonarr_1.get(i);
				
				//Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
				//JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
				
				logslistobj=new LogsListModel();
	            
				logslistobj.setSid(((Long) jObj.get("sid")).intValue());
	            
				logslistobj.setUserSid(((Long) jObj.get("user_sid")).intValue());
				logslistobj.setLogGroupSid(((Long) jObj.get("log_group_sid")).intValue());
				logslistobj.setCategory((String)jObj.get("category"));
				logslistobj.setFilename((String)jObj.get("filename"));
				logslistobj.setFunctionId((String)jObj.get("function_id"));
				logslistobj.setLine(((Long) jObj.get("line")).intValue());
				logslistobj.setLocation(((Long) jObj.get("location")).intValue());
				logslistobj.setLogType((String)jObj.get("log_type"));
				logslistobj.setMessage((String)jObj.get("message"));
				logslistobj.setModule((String)jObj.get("module"));
				logslistobj.setRef01((String)jObj.get("ref_01"));
				logslistobj.setTestCode((String)jObj.get("test_code"));
		        logslistobj.setRef02((String)jObj.get("ref_02"));		//((String)jObj.get("first_name"));
		        logslistobj.setTags((String)jObj.get("tags"));		//((String)jObj.get("last_name"));
		        
		        logslistobj.setUpdatedAt((String)jObj.get("updated_at"));
		        logslistobj.setUpdatedBy((String)jObj.get("updated_by"));
		        listoflogs.add(logslistobj);
				}
				
			
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listoflogs;		
		}
	
	public List uniqueLogType(String id){
		
		String logtype=null;
		List<String> listoflogtype= new ArrayList<String>();
			
		ArrayList<LogsListModel> lglist = (ArrayList<LogsListModel>) getlistLogsInfo(id);
		
		for(LogsListModel logrouplist : lglist)
		{
			logtype = logrouplist.getLogType();
			listoflogtype.add(logtype);
		}
		
		
		List<String> listDistinct = listoflogtype.stream().distinct().collect(Collectors.toList());
		return listDistinct;
		
	}
	
public List uniqueCategory(String id){
		
		String category=null;
		List<String> listofcategory= new ArrayList<String>();
			
		ArrayList<LogsListModel> lglist = (ArrayList<LogsListModel>) getlistLogsInfo(id);
		
		for(LogsListModel logrouplist : lglist)
		{
			category = logrouplist.getCategory();
			listofcategory.add(category);
		}
		
		
		List<String> listDistinct = listofcategory.stream().distinct().collect(Collectors.toList());
		return listDistinct;
		
	}


public List uniqueModule(String id){
	
	String module=null;
	List<String> listofmodule= new ArrayList<String>();
		
	ArrayList<LogsListModel> lglist = (ArrayList<LogsListModel>) getlistLogsInfo(id);
	
	for(LogsListModel logrouplist : lglist)
	{
		module = logrouplist.getModule();
		listofmodule.add(module);
	}
	
	
	List<String> listDistinct = listofmodule.stream().distinct().collect(Collectors.toList());
	return listDistinct;
	
}
	
	
	/*@RequestMapping(value = "/logViewSelect", method = RequestMethod.GET )
	public String  getLogs(Model model,@RequestParam("id") String id) {
		String response = null;
		try {
			List<LogsListModel> logslist = getlistLogsInfo(id);
			
			
			//response = getlistLogsInfo(id);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("logsView");
		//("index","response", response);
		
		
   	 return "redirect:/logsView";
	}*/
	
	
	@RequestMapping(value="/logsView", method = RequestMethod.GET)
	public ModelAndView  viewLogs(@RequestParam("id") String id) {
		List<LogsListModel> logslist = getlistLogsInfo(id);
		List logtype = uniqueLogType(id);
		List category = uniqueCategory(id);
		List module = uniqueModule(id);
		
		ModelAndView model = new ModelAndView("logsView");
		
		model.addObject("logslist", logslist);
		model.addObject("logtype", logtype);
		model.addObject("category", category);
		model.addObject("module", module);
		
		 return model;
	}
	
	/*@RequestMapping("/logsView")
    public ModelAndView  logView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("logsView","message", message);
		
   	 return model;
    }*/

}
