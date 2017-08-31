package com.pjs.project01.CCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.dao.ContentDao;

public class CUpdateCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String pictureUrl = request.getParameter("pictureUrl");
		String description = request.getParameter("description");
		
		ContentDao cdao = new ContentDao();
		cdao.update(code, title, pictureUrl, description);
	}

}
