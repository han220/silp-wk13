<%@page import="com.member.common.FileUpload"%>
<%@page import="com.member.bean.MemberVO"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sid = request.getParameter("id");
	if (sid != ""){  
		int id = Integer.parseInt(sid);
		MemberDAO memberDAO = new MemberDAO();
		MemberVO one = memberDAO.getOne(id);
		memberDAO.deleteOne(id);
		
		if(one.getPhoto() != null)
			FileUpload.deleteFile(request, one.getPhoto() );
	}
	response.sendRedirect("memberlist.jsp");
%>