package com.logui.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CategoryViewController {

	private final String USER_AGENT = "Mozilla/5.0";

	private String sendPost(String subcode,String name,String description, String active) throws Exception {
		
	
	
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
	if(active.equals("on"))
	{
					flag= 1;
	}
	else
	{
		flag=0;
	}
	String urlParameters = String.format("{\"req_data_length\":1,\"req_data\":[{\"master_sid\":\"20\", \"main_code\":\"002\", \"sub_code\":\"%s\",\"name\":\"%s\",\"description\":\"%s\", \"value\":\"12\", \"seq_order\":\"4561\",\"module\":\"kaushik\",\"is_active\":\"%d\", \"updated_by\":\"12\", \"comment\":\"kaushik\",\"ref_01\":\"ref_02\",\"used_code\":\"1\"}] }",subcode,name,description, flag);
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

	@RequestMapping(value = "/categoryView", method = RequestMethod.POST )
	public String  editUserModelView(Model model,@RequestParam String name,@RequestParam String subcode,@RequestParam String description, @RequestParam String active) {
		String response = null;
		try {
			response = sendPost(subcode, name, description, active);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("categoryView");
		//("index","response", response);
		
		
   	 return "redirect:/categoryView";
	}
	
	
		
		
	@RequestMapping("/categoryView")
    public ModelAndView  logView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("categoryView","message", message);
		
		//model.addObject("userlist", userlist);
   	 return model;
    }
	
	@RequestMapping("/addCategory")
    public ModelAndView  addCategoryView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("addCategory","message", message);
		
		//model.addObject("userlist", userlist);
   	 return model;
    }
}
