package com.pjs.project01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjs.project01.CCommand.CCommand;
import com.pjs.project01.CCommand.CDeleteCommand;
import com.pjs.project01.CCommand.CDetailCommand;
import com.pjs.project01.CCommand.CUpdateCommand;
import com.pjs.project01.CCommand.CWriteCommand;
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
	
	@RequestMapping("contentWrite")
	public String contentWrite(HttpServletRequest request, Model model) {
		System.out.println("contentWrite()");
		
		model.addAttribute("request", request);
		command = new CWriteCommand();
		command.execute(model);
		
		return "redirect:Movie";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new CDetailCommand();
		command.execute(model);
		
		return "Content/content_view";
	}
	@RequestMapping(method=RequestMethod.POST, value = "contentUpdate")
	public String contentUpdate(HttpServletRequest request, Model model) {
		System.out.println("contentUpdate()");
		
		model.addAttribute("request", request);
		command = new CUpdateCommand();
		command.execute(model);
		
		return "redirect:Movie";
	}
	
	@RequestMapping("contentDelete")
	public String contentDelete(HttpServletRequest request, Model model) {
		System.out.println("contentDelete()");
		
		model.addAttribute("request", request);
		command = new CDeleteCommand();
		command.execute(model);
		
		return "redirect:Movie";
	}
}
