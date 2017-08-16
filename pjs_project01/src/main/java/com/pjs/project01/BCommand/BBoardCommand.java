package com.pjs.project01.BCommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.pjs.project01.boarddao.BDao;
import com.pjs.project01.boarddto.BDto;

public class BBoardCommand implements  BCommand{

	@Override
	public void execute(Model model) {		
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto>dtos =  dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
 