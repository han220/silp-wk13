package com.member.bean;

import java.util.Date;

public class MemberVO {
	private int sid;
	private String userid, username, password, email, blogurl, photo, detail;
	private Date regdate;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(int sid, String userid, String username,  String email,
			String photo, String detail, Date regdate) {
		super();
		this.sid = sid;
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.photo = photo;
		this.detail = detail;
		this.regdate = regdate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String iusername) {
		this.username = iusername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBlogurl() {
		return blogurl;
	}
	public void setBlogurl(String blogurl) {
		this.blogurl = blogurl;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
