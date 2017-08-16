package com.pjs.project01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.MCommand.MCommand;
import com.pjs.project01.MCommand.MIndexCommnad;

@Controller
public class ViewController {
	
	MCommand commnad;

	@RequestMapping("/Index")
	public String index(Model model) {
		System.out.println("Index()");
		commnad = new MIndexCommnad();
		commnad.execute(model);
				
		return "Index";
	}
	
	@RequestMapping("/Movie")
	public String movie() {
		System.out.println("Movie()");
		
		return "Movie";
	}
	
	@RequestMapping("/Docu")
	public String docu() {
		System.out.println("Docu()");

		
		return "Docu";
	}
	
	@RequestMapping("/News")
	public String news() {
		System.out.println("News()");

		
		return "News";
	}
	
	@RequestMapping("Variety")
	public String variety() {
		System.out.println("Variety()");

		
		return "Variety";
	}
	
	@RequestMapping("DAO_test")
	public String test() {
		System.out.println("DAO_test()");

		
		return "DAO_test";
	}
	
}
