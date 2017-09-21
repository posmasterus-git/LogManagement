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
import com.google.gson.JsonParser;
import com.logui.models.LogGroupModel;
import com.logui.models.LoginModel;
import com.logui.models.UserList;

@Controller
public class LoginController {
	
private final String USER_AGENT = "Mozilla/5.0";


public String listLoginPW(String username, String pw) throws Exception{
	
	
	String response = getLogin(username, pw);
	LoginModel loginmodel = null;
	String status =null;
	List<LoginModel> listLoginModel= new ArrayList<LoginModel>();
	
	try
	{
		
		
		JSONParser parse = new JSONParser();
		JSONObject obj = (JSONObject)parse.parse(response);
		status = obj.get("status").toString();
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
}
	
private String getLogin(String username, String pw) throws Exception {
	final String USER_AGENT = "Mozilla/5.0";
	
	String status =null;
	
	String url = "http://54.153.82.170:4000/atest/api/user_validation/";
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	int flag= -1;
	//add reuqest header
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	con.setRequestProperty("Accept", "application/json");
	con.setRequestProperty("Content-type", "application/json");
	
	String urlParameters = String.format("{\"req_data_length\":1,\"req_data\":[{\"id\":\"%s\",\"pw\":\"%s\"}] }", username, pw);
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
	
	if(responseCode!=200){
		status = "false";
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
	System.out.println("---------------->"+response.toString());
	
	try
	{
	
		JSONParser parse = new JSONParser();
		JSONObject obj1 = (JSONObject)parse.parse(response.toString());
		status = obj1.get("status").toString();
		System.out.println(status+"--------------------->");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	return status;
}

	
public int getSID(String id){
	
	
	String inline = "";
	int sid=-1;
	
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
			sid=((Long) jObj.get("master_sid")).intValue();
			
			}
			
		
		//Disconnect the HttpURLConnection stream
		conn.disconnect();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return sid;		
	}




	
@RequestMapping("/login")
public ModelAndView  addUser() {
    
 String message = "<br><div style='text-align:center;'>"
			+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
	

 return new ModelAndView("login", "message", message);
}

/*@RequestMapping(method=RequestMethod.GET)
public int passUsername(@RequestParam String username){
	String response = null;
	int sid= -1;
	
	try {
		
		sid = getSID(username);
		System.out.println(response);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return sid;
	
}*/
	

	
	@RequestMapping(value = "/logGroupHomelogin" , method=RequestMethod.POST)
	public String  createLogGroupModelView(Model model,@RequestParam String username,@RequestParam String password) {
		String response = null;
		try {
			response = getLogin(username, password);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("logGroupHomelogin");
		//("index","response", response);
		
		if(response.equals("true"))
		{
			return "redirect:/logGroupHome?userid="+username;
		}
		
		else {
			return "redirect:/login";
		}
		
	}
	
	
	

}
