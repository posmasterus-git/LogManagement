package com.logui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LogTypeViewController {
	
	
	@RequestMapping("/logTypeView")
    public ModelAndView  logView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("logTypeView","message", message);
		
		//model.addObject("userlist", userlist);
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
		
}
