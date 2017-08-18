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
	
	@RequestMapping("upload_form")
	public String upload_form(Model model) {
		System.out.println("upload_form()");
		
		return "Content/upload_form";
	}
}
