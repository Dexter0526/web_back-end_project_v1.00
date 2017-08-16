package com.pjs.project01.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class MLogoutCommand implements MCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session2 = request.getSession();
		session2.invalidate();
		
	}

}
