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
<form action="memberedit.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="sid" value="<%=u.getSid() %>" />
<table>
<tr><td>User ID:</td><td><input type="text" name="userid" value="<%= u.getUserid() %>"/></td></tr>
<tr><td>User name:</td><td><input type="text" name="username" value="<%= u.getUsername() %>"/></td></tr>
<tr><td>Email address:</td><td><input type="text" name="email" value="<%= u.getEmail() %>"/></td></tr>
<tr><td>Photo:</td>
<td>
	<input type="file" name="photo"/> <br />
	<c:if test="${vo.getPhoto() ne ''}"> <img src="${pageContext.request.contextPath }/upload/${vo.getPhoto()}" class="photo"></c:if></td></tr>
<tr><td>Introduce myself:</td><td><textarea cols="50" rows="5" name="detail"><%= u.getDetail() %></textarea></td></tr>
<tr><td><a href="memberlist.jsp">List</a></td><td align="right"><input type="submit" value="Add Member"/></td></tr>
</table>
</form>

</body>
</html>