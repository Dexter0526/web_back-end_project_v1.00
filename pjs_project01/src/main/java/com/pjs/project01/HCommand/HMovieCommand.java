package com.pjs.project01.HCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.dao.HitDao;
import com.pjs.project01.dto.HitDto;

public class HMovieCommand implements HCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userid = request.getParameter("userid");
		System.out.println(userid);
		
		HitDao hdao = new HitDao();
		hdao.HitMovie(userid);
		System.out.println("정상 실행");
		//HitDto hdto = hdao.Hit_View(userid);
		
		//System.out.println(hdto);
	}

}
