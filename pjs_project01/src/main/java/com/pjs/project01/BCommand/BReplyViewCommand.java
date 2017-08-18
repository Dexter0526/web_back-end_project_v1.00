package com.pjs.project01.BCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pjs.project01.dao.BDao;
import com.pjs.project01.dto.BDto;

public class BReplyViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BDao bdao = new BDao();
		BDto bdto = bdao.reply_view(bId);
		
		model.addAttribute("reply_view", bdto);
		
	}

}
