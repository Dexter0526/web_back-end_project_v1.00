package com.pjs.project01.CCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.dao.ContentDao;

public class CDeleteCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String code = request.getParameter("code");
		ContentDao cdao = new ContentDao();
		cdao.delete(code);
	}

}
