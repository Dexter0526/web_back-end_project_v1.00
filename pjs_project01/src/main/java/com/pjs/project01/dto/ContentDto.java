package com.pjs.project01.dto;

public class ContentDto {

	private Integer code;
	private String name;
	private String userid;
	private String description;;
	private String pictureUrl;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public ContentDto(Integer code, String name, String userid, String description, String pictureUrl) {
		super();
		this.code = code;
		this.name = name;
		this.userid = userid;
		this.description = description;
		this.pictureUrl = pictureUrl;
	}
	
	public ContentDto() {
		// TODO Auto-generated constructor stub
	}
	
}
