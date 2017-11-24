package net.frog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	//move to main
	@RequestMapping(value="/main/Main.do")
	public String main(){
		
		
		return "/main/Main";
	}
	
	@RequestMapping(value="/main/inputTest.do")
	public String inputTest(){
		return "/main/inputTest";
	}
	
}
