package com.pjs.project01.BCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.boarddao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao bdao = new BDao();
		bdao.modify(bId, bName, bTitle, bContent);
	}

}
