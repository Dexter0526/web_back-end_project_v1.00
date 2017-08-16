package com.pjs.project01.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.pjs.project01.memberdao.MemberDao;
import com.pjs.project01.memberdto.MemberDto;

public class MLoginCommand implements MCommand {

	@Override
	public void execute(Model model) {

		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = new MemberDao();
		int result = mdao.userCheck(userid, pwd);
		
		if(result == 1) {
			MemberDto mdto = mdao.getMember(userid);

			session2.setAttribute("loginUser", mdto);
			session2.setAttribute("message", "회원님 안녕하세요.");
		}else if(result == 0) {
			session2.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {
			session2.setAttribute("message", "회원이 존재하지 않습니다.");
		}
	}

}
