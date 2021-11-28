<%@page import="com.member.bean.MemberVO"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	MemberDAO memberDAO = new MemberDAO();
	String id=request.getParameter("id");	
	MemberVO u=memberDAO.getOne(Integer.parseInt(id));
	request.setAttribute("vo", u);
%>

<h1>Add Edit Member</h1>
<table>
<tr><td>User ID:</td><td><%= u.getUserid() %></td></tr>
<tr><td>User name:</td><td><%= u.getUsername() %></td></tr>
<tr><td>Email address:</td><td><%= u.getEmail() %></td></tr>
<tr><td>Photo:</td><td><c:if test="${vo.getPhoto() ne ''}"> <img src="${pageContext.request.contextPath }/upload/${vo.getPhoto()}" class="photo"></c:if></td></tr>
<tr><td>Introduce myself:</td><td><%= u.getDetail() %></td></tr>
<tr><td><a href="memberlist.jsp">List</a></td><td align="right"></td></tr>
</table>

</body>
</html>