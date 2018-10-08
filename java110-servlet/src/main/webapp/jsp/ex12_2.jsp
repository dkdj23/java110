<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션태그</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean - scope의 기본값은 page이다.</h1>

<%
request.setAttribute("name", "유관순");//ServletRequest 보관소
pageContext.setAttribute("name","안중근");//pageContext 보관소
%>

<jsp:useBean 
	id="name" 
	class="java.lang.String"/>
<p>이름: <%=name%>

</body>
</html>