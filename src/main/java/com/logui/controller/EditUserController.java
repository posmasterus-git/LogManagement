package com.logui.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.logui.models.UserList;

@Controller
public class EditUserController {
	private final String USER_AGENT = "Mozilla/5.0";

	
	public List<UserList> getlistUserInfo(String id){
		
		
		String inline = "";
		UserList userlistobj = null;
		List<UserList> listofusers= new ArrayList<UserList>();
		
		try
		{
			URL url = new URL("http://54.153.82.170:4000/atest/api/logging_user/id/"+id);
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
				
				userlistobj=new UserList();
	            
	            userlistobj.setSid(((Long) jObj.get("sid")).intValue());
	            
		        userlistobj.setId((String)jObj.get("id"));
		        userlistobj.setMasterSid(((Long) jObj.get("master_sid")).intValue());
		        userlistobj.setFirstName((String)jObj.get("first_name"));
		        userlistobj.setLastName((String)jObj.get("last_name"));
		        userlistobj.setIsActive(((Long) jObj.get("is_active")).intValue());
		        userlistobj.setUpdatedAt((String)jObj.get("updated_at"));
		        userlistobj.setUpdatedBy((String)jObj.get("updated_by"));
		        listofusers.add(userlistobj);
				}
				
			
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listofusers;		
		}
	
	
	private String sendPut(String userid,String firstname,String lastname, String active, String master_username) throws Exception {
			int sid=-1;
		String on= "on";
		//String lastName = lastname;
		//System.out.println(master_username+"---------------------->This is master_username");
		LoginController logcont = new LoginController();
		int mastersid = logcont.getSID(master_username);
		
		ArrayList<UserList> userlist = (ArrayList<UserList>) getlistUserInfo(userid);
		int flag= 1;
		for(UserList ulist : userlist)
		{
			sid = ulist.getSid();
		}
		   
		Gson gson =new Gson();
		
		String url = "http://54.153.82.170:4000/atest/api/logging_user/";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		//add reuqest header
		con.setRequestMethod("PUT");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Content-type", "application/json");
		System.out.println(active+"----------------------------------------------- Active-1235467445--------------------------------------------------------");
		if(active.equals(","+on))
				{
			
						flag= 1;
				}
		else
		{
			
			flag=0;
		}
		String urlParameters = String.format("{\"req_data_length\":1,\"req_data\":[{\"sid\": %d,\"id\":\"%s\",\"master_sid\":\"%d\",\"first_name\":\"%s\",\"last_name\":\"%s\",\"is_active\":\"%d\",\"updated_by\":\"%s\"}] }",sid, userid, mastersid, firstname, lastname, flag, master_username);
		//String urlParameters= "{\"req_data_length\":1,\"req_data\":[{\"id\":"+userid+",\"master_sid\":\"21\",\"first_name\":"+firstname+",\"last_name\":"+lastname+",\"is_active\":\"0\",\"updated_by\":\"ishita\"}] }";
		

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'PUT' request to URL : " + url);
		System.out.println("Put parameters : " + urlParameters);
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
	
	
	private String delete(String id) throws Exception {
		
		String firstname = null, lastname = null, updatedby=null;
		int mastersid = 0, active =-1; 
		
	
	ArrayList<UserList> userlist = (ArrayList<UserList>) getlistUserInfo(id);
	
	for(UserList ulist : userlist)
	{
		
		firstname = ulist.getFirstName();
		lastname= ulist.getLastName();
		active = ulist.getIsActive();
		mastersid = ulist.getMasterSid();
		updatedby = ulist.getUpdatedBy();
		
	}
	
	
	String url = "http://54.153.82.170:4000/atest/api/logging_user/";
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	int flag= -1;
	//add reuqest header
	con.setRequestMethod("DELETE");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	con.setRequestProperty("Accept", "application/json");
	con.setRequestProperty("Content-type", "application/json");
	
	String urlParameters = String.format("{\"req_data_length\":1,\"req_data\":[{\"id\":\"%s\",\"master_sid\":%d ,\"first_name\":\"%s\",\"last_name\":\"%s\",\"is_active\":\"%d\",\"updated_by\":\"%s\"}] }", id, mastersid, firstname, lastname, active, updatedby);
	//String urlParameters= "{\"req_data_length\":1,\"req_data\":[{\"id\":"+userid+",\"master_sid\":\"21\",\"first_name\":"+firstname+",\"last_name\":"+lastname+",\"is_active\":\"0\",\"updated_by\":\"ishita\"}] }";
	

	// Send post request
	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(urlParameters);
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'DELETE' request to URL : " + url);
	System.out.println("DELETE parameters : " + urlParameters);
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
	
	
	@RequestMapping(value="/editUser", method = RequestMethod.GET)
    public ModelAndView  addUser(@RequestParam("id") String id) {
		List<UserList> userlist = getlistUserInfo(id);
		ModelAndView model = new ModelAndView("editUser","userlist", userlist);
		
   	 return model;
	}
	
	@RequestMapping(value="/deleteUser", method = RequestMethod.GET)
    public String  deleteUser(@RequestParam("id") String id, Model model,@RequestParam String username) {
		String response = null;
		try {
			
			response = delete(id);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		if(response!=null){
			model.addAttribute("deleteUser");
			
			System.out.println(response);
			return "redirect:/index?username="+username+"SUCCESS";
			
		}
		else
		{
			return "redirect:/index?username="+username+"ERROR";
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST )
	public String  editUserModelView(Model model,@RequestParam String userid,@RequestParam String firstname,@RequestParam String lastname, @RequestParam String active, @RequestParam String username) {
		String response = null;
		System.out.println(active+"--------------------------------------->active<--------------------------------------");
		
		
		try {
			response = sendPut(userid, firstname, lastname, active, username);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("index");
		//("index","response", response);
		
		
   	 return "redirect:/index?username="+username;
	}
	
	
	
}
