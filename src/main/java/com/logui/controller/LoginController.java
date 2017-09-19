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

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.logui.models.LoginModel;
import com.logui.models.UserList;

@Controller
public class LoginController {
	
private final String USER_AGENT = "Mozilla/5.0";

	
private String sendPost(String username, String pw) throws Exception {
	final String USER_AGENT = "Mozilla/5.0";
	
	
	Scanner sc=new Scanner(source);
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
	//return response.toString();
	
	
	
	
	JSONParser parse = new JSONParser();
	JSONObject obj1 = (JSONObject)parse.parse(inputLine);
	JSONArray jsonarr_1 = (JSONArray) obj1.get("data");
	
	JSONObject jObj = (JSONObject)jsonarr_1.get(1);
	

}

	
	
	@RequestMapping(value = "/logGroupHome" )
	public String  createLogGroupModelView(Model model,@RequestParam String username,@RequestParam String password) {
		String response = null;
		try {
			response = getLogin(username, password);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("logGroupHome");
		//("index","response", response);
		
		
   	 return "redirect:/logGroupHome";
	}
	
	
	

}
