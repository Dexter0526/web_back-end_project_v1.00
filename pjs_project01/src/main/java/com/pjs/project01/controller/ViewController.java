package com.pjs.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.CCommand.CCommand;
import com.pjs.project01.CCommand.CListCommand;
import com.pjs.project01.MCommand.MCommand;
import com.pjs.project01.MCommand.MIndexCommnad;
import com.pjs.project01.util.Constant;

@Controller
public class ViewController {
	
	MCommand command;
	CCommand ccommand;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/Index")
	public String index(Model model) {
		System.out.println("Index()");
		command = new MIndexCommnad();
		command.execute(model);
				
		return "Index";
	}
	
	@RequestMapping("/Movie")
	public String movie(Model model) {
		System.out.println("Movie()");
		
		ccommand = new CListCommand();
		ccommand.execute(model);
		
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
