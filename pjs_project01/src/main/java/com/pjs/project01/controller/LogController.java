package com.pjs.project01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjs.project01.MCommand.MLoginCommand;
import com.pjs.project01.MCommand.MLogoutCommand;
import com.pjs.project01.MCommand.MUpdateCommnad;
import com.pjs.project01.MCommand.MCommand;
import com.pjs.project01.MCommand.MIdCheck;
import com.pjs.project01.MCommand.MJoinCommand;


@Controller
public class LogController {
	
	MCommand command;
	
	@RequestMapping("login_process")
	public String log_process(HttpServletRequest request, Model model) {
		System.out.println("login_process()");
		
		model.addAttribute("request", request);
		command = new MLoginCommand();
		command.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("join")
	public String join() {
		System.out.println("join()");

		
		return "/Log/join";
	}
	
	
	@RequestMapping("logout_process")
	public String logout_process(HttpServletRequest request, Model model) {
		System.out.println("logout_process()");
		
		model.addAttribute("request", request);
		command = new MLogoutCommand();
		command.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("join_process")
	public String join_process(HttpServletRequest request, Model model) {
		System.out.println("join_process()");
		
		model.addAttribute("request", request);
		command = new MJoinCommand();
		command.execute(model);
		
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
	
	@RequestMapping("update_process")
	public String update_process(HttpServletRequest request, Model model) {
		System.out.println("update_process()");
		model.addAttribute("request", request);
		command = new MUpdateCommnad();
		command.execute(model);
		
		return "redirect:Index";
	}
	
	@RequestMapping("memberUpdate")
	public String memberUpdate() {
		System.out.println("memberUpdate()");
		
		return "/Log/memberUpdate";
	}
	
}
