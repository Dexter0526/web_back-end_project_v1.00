package com.pjs.project01.CCommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.pjs.project01.dao.ContentDao;
import com.pjs.project01.dto.ContentDto;

public class CListCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		ContentDao cdao = new ContentDao();
		ArrayList<ContentDto> dtos = cdao.list();
		
		model.addAttribute("movieList", dtos);
	}

}
