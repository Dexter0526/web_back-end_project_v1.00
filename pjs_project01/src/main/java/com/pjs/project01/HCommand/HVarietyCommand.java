package com.pjs.project01.HCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.dao.HitDao;

public class HVarietyCommand implements HCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userid = request.getParameter("userid");
		System.out.println(userid);
		
		HitDao hdao = new HitDao();
		hdao.HitVariety(userid);
		System.out.println("정상 실행");
	}

}
