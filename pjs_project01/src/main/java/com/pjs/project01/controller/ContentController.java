package com.pjs.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.CCommand.CCommand;
import com.pjs.project01.util.Constant;

@Controller
public class ContentController {

	CCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("contentWrite_view")
	public String contentWrite_view(Model model) {
		System.out.println("contentWrite_view()");
		
		return "Content/contentWrite_view";
	}
	
	@RequestMapping("contentUpdate")
	public String contentUpdate() {
		
		return null;
	}
	
	@RequestMapping("contentDelete")
	public String contentDelete() {
		
		return null;
	}
}
