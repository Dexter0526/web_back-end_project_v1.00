package com.pjs.project01.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pjs.project01.dto.ContentDto;
import com.pjs.project01.util.Constant;

public class ContentDao {

	DataSource dataSource;
	
	JdbcTemplate template;
	
	public ContentDao() {
		// TODO Auto-generated constructor stub
		template = Constant.template;
	}
	
	public ArrayList<ContentDto> list(){
		
		String query = "select * from movie";
		
		return (ArrayList<ContentDto>) template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}
	
	
}
