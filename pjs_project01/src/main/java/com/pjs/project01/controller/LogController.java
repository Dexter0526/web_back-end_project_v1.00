package com.pjs.project01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.MCommand.MLoginCommand;
import com.pjs.project01.MCommand.MLogoutCommand;
import com.pjs.project01.MCommand.MUpdateCommnad;
import com.pjs.project01.HCommand.HCommand;
import com.pjs.project01.HCommand.HJoinCommand;
import com.pjs.project01.MCommand.MCommand;
import com.pjs.project01.MCommand.MIdCheck;
import com.pjs.project01.MCommand.MJoinCommand;


@Controller
public class LogController {
	
	MCommand command;
	HCommand hcommand;
	
	@RequestMapping("login")
	public String log_process(HttpServletRequest request, Model model) {
		System.out.println("login()");
		
		model.addAttribute("request", request);
		command = new MLoginCommand();
		command.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("join_view")
	public String join() {
		System.out.println("join_view()");

		
		return "/Log/join_view";
	}
	
	
	@RequestMapping("logout")
	public String logout_process(HttpServletRequest request, Model model) {
		System.out.println("logout()");
		
		model.addAttribute("request", request);
		command = new MLogoutCommand();
		command.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("join")
	public String join_process(HttpServletRequest request, Model model) {
		System.out.println("join()");
		
		model.addAttribute("request", request);
		command = new MJoinCommand();
		command.execute(model);
		
		hcommand = new HJoinCommand();
		hcommand.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("idCheck")
	public String idCheck() {
		System.out.println("idCheck()");
		
		return "/Log/idCheck";
	}
	
	@RequestMapping("idCheck_forward")
	public String idCheck_forward(HttpServletRequest request, Model model) {
		System.out.println("idCheck_forward()");
		
		model.addAttribute("request", request);
		command = new MIdCheck();
		command.execute(model);
		System.out.println("메서드 종료");
		
		return "redirect:idCheck";
	}
	
	@RequestMapping("update")
	public String update_process(HttpServletRequest request, Model model) {
		System.out.println("update()");
		model.addAttribute("request", request);
		command = new MUpdateCommnad();
		command.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("memberUpdate_view")
	public String memberUpdate() {
		System.out.println("memberUpdate_view()");
		
		return "/Log/memberUpdate_view";
	}
	
}
