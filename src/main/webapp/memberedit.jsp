<%@page import="com.member.bean.MemberVO"%>
<%@page import="com.member.common.FileUpload"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.member.dao.BoardDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<%
	MemberDAO memberDAO = new MemberDAO();
	FileUpload upload = new FileUpload();
	MemberVO u = upload.uploadPhoto(request);
	int i=memberDAO.updateMember(u);
	
	String msg = "데이터 수정 성공 !";
	if(i == 0) msg = "[에러] 데이터 수정 ";
%>

<script>
	alert('<%=msg%>');
	location.href='memberlist.jsp';
</script>