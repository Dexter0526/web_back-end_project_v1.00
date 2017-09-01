package com.pjs.project01.dto;

public class HitDto {

	private String userid;
	private int movie;
	private int variety;
	private int news;
	private int docu;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getMovie() {
		return movie;
	}
	public void setMovie(int movie) {
		this.movie = movie;
	}
	public int getVariety() {
		return variety;
	}
	public void setVariety(int variety) {
		this.variety = variety;
	}
	public int getNews() {
		return news;
	}
	public void setNews(int news) {
		this.news = news;
	}
	public int getDocu() {
		return docu;
	}
	public void setDocu(int docu) {
		this.docu = docu;
	}
	
	public HitDto() {
		// TODO Auto-generated constructor stub
	}
	
	public HitDto(String userid, int movie, int variety, int news, int docu) {
		super();
		this.userid = userid;
		this.movie = movie;
		this.variety = variety;
		this.news = news;
		this.docu = docu;
	}
	
}
