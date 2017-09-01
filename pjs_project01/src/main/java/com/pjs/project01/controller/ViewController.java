package com.pjs.project01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.CCommand.CCommand;
import com.pjs.project01.CCommand.CListCommand;
import com.pjs.project01.HCommand.HCommand;
import com.pjs.project01.HCommand.HDocuCommand;
import com.pjs.project01.HCommand.HMovieCommand;
import com.pjs.project01.HCommand.HNewsCommand;
import com.pjs.project01.HCommand.HVarietyCommand;
import com.pjs.project01.MCommand.MCommand;
import com.pjs.project01.util.Constant;

@Controller
public class ViewController {
	
	MCommand mcommand;
	CCommand ccommand;
	HCommand hcommand;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/Index")
	public String index(Model model) {
		System.out.println("Index()");
		
		return "Index";
	}
	
	@RequestMapping("/Movie")
	public String movie(HttpServletRequest request, Model model) {
		System.out.println("Movie()");
		
		model.addAttribute("request", request);

		hcommand = new HMovieCommand();
		System.out.println("Hitm command");
		hcommand.execute(model);
		System.out.println("hitm method");
		
		ccommand = new CListCommand();
		ccommand.execute(model);
		
		return "Movie";
	}
	
	@RequestMapping("/Docu")
	public String docu(HttpServletRequest request, Model model) {
		System.out.println("Docu()");
		
		model.addAttribute("request", request);
		
		hcommand = new HDocuCommand();
		hcommand.execute(model);
		
		return "Docu";
	}
	
	@RequestMapping("/News")
	public String news(HttpServletRequest request, Model model) {
		System.out.println("News()");
		
		model.addAttribute("request", request);
		
		hcommand = new HNewsCommand();
		hcommand.execute(model);

		
		return "News";
	}
	
	@RequestMapping("Variety")
	public String variety(HttpServletRequest request, Model model) {
		System.out.println("Variety()");

		model.addAttribute("request", request);
		
		hcommand = new HVarietyCommand();
		hcommand.execute(model);
		
		return "Variety";
	}
	
	@RequestMapping("DAO_test")
	public String test() {
		System.out.println("DAO_test()");

		
		return "DAO_test";
	}
	
}
