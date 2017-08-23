package com.pjs.project01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.CCommand.CCommand;
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
		
		return "redirect:movie";
	}
	
	@RequestMapping("contentUpdate_view")
	public String contentUpdate_view(Model model) {
		System.out.println("contentUpdate_view()");
		
		return "Content/contentUpdate_view";
	}
	@RequestMapping("contentUpdate")
	public String contentUpdate() {
		System.out.println("contentUpdate()");
		
		return "redirect:movie";
	}
	
	@RequestMapping("contentDelete")
	public String contentDelete() {
		System.out.println("contentDelete()");
		
		return null;
	}
	
	@RequestMapping("contentList")
	public String contentList() {
		System.out.println("contentList()");
		
		return null;
	}
}
