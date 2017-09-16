package com.logui.controller;

import com.logui.models.*;

/*
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddUserController {
		
	@RequestMapping(value = "/adduserpost", method = RequestMethod.POST)
    public String submit(@ModelAttribute("adduserpost")UserList userlist, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("userid", userlist.getId());
        model.addAttribute("firstname", userlist.getFirstName());
        model.addAttribute("lastname", userlist.getLastName());
        model.addAttribute("active", userlist.getIsActive());
        return "addUser";
    }
	
/*	@RequestMapping(value = "/index")
    public String testAction(@RequestParam String fieldName) {
        // yourValue contain the value post from the html form
        return "yourview";
    }*/
	
	@RequestMapping("/addUser")
    public ModelAndView  addUser() {
        
	 String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		

	 return new ModelAndView("addUser", "message", message);
    }
	
}
