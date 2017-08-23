package com.pjs.project01.CCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.dao.ContentDao;

public class CWriteCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int code = Integer.parseInt(request.getParameter("code"));
		String title = request.getParameter("title");
		String pictureUrl = request.getParameter("pictureUrl");
		String userid = request.getParameter("userid");
		String description = request.getParameter("description");
		
		ContentDao cdao = new ContentDao();
		cdao.write(code, title, pictureUrl, userid, description);
		
	}

}
