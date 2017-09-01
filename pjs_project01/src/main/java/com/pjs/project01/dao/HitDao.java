package com.pjs.project01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.pjs.project01.dto.HitDto;
import com.pjs.project01.util.Constant;

public class HitDao {

	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public HitDao() {
		template = Constant.template;
	}
	
	public void write(final String userid) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into user_hit(userid) values(?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, userid);
				
				return pstmt;
			}
		});
	}
	
	public HitDto Hit_View(String strID) {
		
		HitMovie(strID);
		String query = "select * from user_hit where userid = " + strID;
		System.out.println(query);
		
		return template.queryForObject(query, new BeanPropertyRowMapper<HitDto>(HitDto.class));
	}
	
	public void HitMovie(final String userid) {
		System.out.println(userid);
		String query = "update user_hit set movie = movie + 1 where userid = ?";
		System.out.println(query);
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, userid);
				System.out.println("dao 입력 완료");
			}
		});
	}
	
	public void HitDocu(final String userid) {
		String query = "update user_hit set docu = docu + 1 where userid = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, userid);
			}
		});
	}
	
	public void HitNews(final String userid) {
		String query = "update user_hit set news = news + 1 where userid = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, userid);
			}
		});
	}
	
	public void HitVariety(final String userid) {
		String query = "update user_hit set variety = variety + 1 where userid = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, userid);
			}
		});
	}
}
