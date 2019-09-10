package com.ccgg.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ccgg.beans.Person;

@Controller
public class HelloController {
	
	@Autowired
	private Person person;
	
	@RequestMapping("/hello")
	public ModelAndView sayHello(HttpServletRequest request){
		String name = request.getParameter("name");
		System.out.println(name);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("title1", "Hello " + name  + ", welcome to Spring MVC");
		return mav;
	}
	
	@RequestMapping("/main")
	public String goMain(ModelMap model, HttpSession session){
		model.addAttribute("msg1", "This is message.");
		session.setAttribute("welcome1", "Welcome from session");
		return "mainpage";
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public String getData(){
		return "This is data!";
	}
	
	@RequestMapping("/person")
	@ResponseBody
	public Person getPerson(){
		return person;
	}
	
}
