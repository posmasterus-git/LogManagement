package com.logui.controller;

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

import com.logui.models.LoginModel;
import com.logui.models.UserList;

@Controller
public class LoginController {
	
private final String USER_AGENT = "Mozilla/5.0";

	
	public List<LoginModel> getMasterInfo(String id){
		
		
		String inline = "";
		LoginModel logintobj = null;
		List<LoginModel> listofmaster= new ArrayList<LoginModel>();
		
		try
		{
			URL url = new URL("http://54.153.82.170:4000/atest/api/logging_master/id/"+id);
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
				
				logintobj=new LoginModel();
	            
				logintobj.setSid(((Long) jObj.get("sid")).intValue());
	            
				logintobj.setId((String)jObj.get("id"));
		       
				logintobj.setFirstName((String)jObj.get("first_name"));
				logintobj.setLastName((String)jObj.get("last_name"));
		       
				logintobj.setUpdatedAt((String)jObj.get("updated_at"));
		        
		        listofmaster.add(logintobj);
				}
				
			
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listofmaster;		
		}
	
	
	
	/*@RequestMapping(value = "/logGroupHome", method = RequestMethod.POST )
	public String  createLogGroupModelView(Model model,@RequestParam String logroupid,@RequestParam String name,@RequestParam String description, @RequestParam String active) {
		String response = null;
		try {
			response = sendPost(logroupid, name, description, active);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("logGroupHome");
		//("index","response", response);
		
		
   	 return "redirect:/logGroupHome";
	}*/
	
	
	

}
