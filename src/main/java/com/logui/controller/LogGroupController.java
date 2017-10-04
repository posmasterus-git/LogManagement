package com.logui.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
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

import com.logui.models.LogGroupModel;
import com.logui.models.LoginModel;
import com.logui.models.UserList;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class LogGroupController {
	
	
	public List<LogGroupModel> listlogroupInfo(String username){
		
		LoginController logcont = new LoginController();
		int mastersid = logcont.getSID(username);
		
		String inline = "";
		LogGroupModel loggrouplistobj = null;
		List<LogGroupModel> listofloggroups= new ArrayList<LogGroupModel>();
		
		try
		{
			URL url = new URL("http://54.153.82.170:4000/atest/api/logging_log_group/search?master_sid="+mastersid);
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
	
	
	private String sendPost(String logroupid, String name, String description, String active, String master_username) throws Exception {
		final String USER_AGENT = "Mozilla/5.0";
		
		LoginController logcont = new LoginController();
		int mastersid = logcont.getSID(master_username);
		
		String url = "http://54.153.82.170:4000/atest/api/logging_log_group/";
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
		String urlParameters = String.format("{\"req_data_length\":1,\"req_data\":[{\"id\":\"%s\",\"master_sid\":\"%d\",\"name\":\"%s\",\"description\":\"%s\",\"is_active\":\"%d\",\"updated_by\":\"%s\"}] }", logroupid, mastersid,name, description, flag, master_username);
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

	
	@RequestMapping(value="/logGroupHome", method=RequestMethod.GET )
    public ModelAndView  logView(@RequestParam("username") String username) {
		
		List<LogGroupModel> logrouplist = listlogroupInfo(username);
		ModelAndView model = new ModelAndView("logGroupHome","logrouplist", logrouplist);
		
		
		//model.addObject("userlist", userlist);
   	 return model;
    }
	
	
	
/*	@RequestMapping(value = "/logGroupHome", method = RequestMethod.POST )
    public ModelAndView  createUserModelView(@RequestParam String logroupid,@RequestParam String name,@RequestParam String description, @RequestParam String active) {
		String response = null;
		
		System.out.println("-------------------------------------------->"+active);
		try {
			response = sendPost(logroupid, name, description, active);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("logGroupHome");
		
		
   	 return model;
    }
	*/
	@RequestMapping(value = "/logGroupHome", method = RequestMethod.POST )
	public String  createLogGroupModelView(Model model,@RequestParam String logroupid,@RequestParam String name,@RequestParam String description, @RequestParam String active, @RequestParam String username) {
		String response = null;
		
	LoginController loginco= new LoginController();
	
		
		try {
			
			response = sendPost(logroupid, name, description, active, username);
			
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("logGroupHome");
		//("index","response", response);
		
		
   	 return "redirect:/logGroupHome?username="+username;
	}
	
	
}
