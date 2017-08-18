package com.pjs.project01.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.pjs.project01.dao.MemberDao;

public class MIdCheck implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("체크 시작");
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		//HttpSession session2 = request.getSession(); 
		
		String userid = request.getParameter("userid");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.confirmID(userid);
		model.addAttribute("userid", userid);
		model.addAttribute("result", result);
		System.out.println("체크 끝");
	}

}
