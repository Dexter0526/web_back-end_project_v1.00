package com.pjs.project01.MCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.pjs.project01.dao.MemberDao;
import com.pjs.project01.dto.MemberDto;

public class MUpdateCommnad implements MCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			String userid = request.getParameter("userid");
			MemberDao mdao = MemberDao.getInstance();
			MemberDto mdto = mdao.getMember(userid);
			request.setAttribute("mdto", mdto);
		}else if(method.equals("POST")) {
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
				MemberDao mDao = MemberDao.getInstance();
				mDao.updateMember(mdto);
				
				session2.setAttribute("loginUser", mdto);
				session2.setAttribute("message", "회원정보를 수정하였습니다.");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("정상 가동");
	}
}
