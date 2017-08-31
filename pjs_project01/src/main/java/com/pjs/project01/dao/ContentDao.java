package com.pjs.project01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

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
				String query = "insert into movie (code, title, pictureUrl, userid, description) values(?, ?, ?, ?, ?)";
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
	
	public ContentDto detailView(String strCODE) {
		
		upHit(strCODE);		
		String query = "select * from movie where code = " + strCODE;
		
		return template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}
	
	public void upHit(final String code) {
		String query = "update movie set Hit = Hit + 1 where code = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(code));
				
			}
		});
		
	}
	
	public void update(final String code, final String title, final String pictureUrl, final String description) {
		String query = "update movie set title = ?, pictureUrl = ?, description = ? where code = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, title);
				ps.setString(2, pictureUrl);
				ps.setString(3, description);
				ps.setInt(4, Integer.parseInt(code));
			}
		});
	}
	
	public void delete(final String strCODE) {
		String query = "delete from movie where code = ?";
		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strCODE);
			}
		});
	}
	
}
