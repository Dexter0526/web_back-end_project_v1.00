package com.pjs.project01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjs.project01.BCommand.BoardCommand;
import com.pjs.project01.BCommand.BCommand;
import com.pjs.project01.BCommand.BContentCommand;
import com.pjs.project01.BCommand.BDeleteCommand;
import com.pjs.project01.BCommand.BModifyCommand;
import com.pjs.project01.BCommand.BReplyCommand;
import com.pjs.project01.BCommand.BReplyViewCommand;
import com.pjs.project01.BCommand.BWriteCommand;
import com.pjs.project01.util.Constant;

@Controller
public class BoardController {

	BCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/board")
	public String board(Model model) {
		System.out.println("board()");
		
		command = new BoardCommand();
		command.execute(model);

		return "board";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "Board/write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);

		return "redirect:board";
	}
	
	@RequestMapping("/board_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("board_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);

		return "Board/board_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:board";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "/Board/reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:board";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);

		
		return "redirect:board";
	}
	
}
