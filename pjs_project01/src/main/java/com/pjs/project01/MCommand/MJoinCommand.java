package com.pjs.project01.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.pjs.project01.memberdao.MemberDao;
import com.pjs.project01.memberdto.MemberDto;

public class MJoinCommand implements MCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		String method = request.getMethod();

		if(method.equals("GET")){
			System.out.println("안녕~~~~");
		}else if(method.equals("POST")){
			try {
				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("name");
				String userid = request.getParameter("userid");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");

				MemberDto mdto = new MemberDto();
				mdto.setName(name);
				mdto.setUserid(userid);
				mdto.setPwd(pwd);
				mdto.setEmail(email);
				mdto.setPhone(phone);

				MemberDao mdao = MemberDao.getInstance();
				int result = mdao.insertMember(mdto);

				if(result ==1){
					session2.setAttribute("userid", mdto.getUserid());
					session2.setAttribute("message", "회원 가입에 성공했습니다.");
				}else{
					session2.setAttribute("message", "회원 가입에 실패했습니다.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("회원가입 정상가동");
	}

}
