package com.logui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ModuleViewController {

	@RequestMapping("/moduleView")
    public ModelAndView  logView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("moduleView","message", message);
		
		//model.addObject("userlist", userlist);
   	 return model;
    }
	
	@RequestMapping("/addModule")
    public ModelAndView  addModuleView() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		ModelAndView model = new ModelAndView("addModule","message", message);
		
		//model.addObject("userlist", userlist);
   	 return model;
    }
	
}
