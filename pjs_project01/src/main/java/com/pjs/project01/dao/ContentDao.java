package com.pjs.project01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

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
	
	public void write(final int code, final String title, final String pictureUrl, final String userid, final String description) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into movie values(?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, code);
				pstmt.setString(2, title);
				pstmt.setString(3, pictureUrl);
				pstmt.setString(4, userid);
				pstmt.setString(5, description);
				
				return pstmt;
			}
		});
	}
	
}
